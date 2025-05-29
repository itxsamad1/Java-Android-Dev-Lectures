const express = require('express');
const router = express.Router();
const db = require('../config/db.config');

// Get all orders
router.get('/', async (req, res) => {
    try {
        const result = await db.query(`
            SELECT o.*, u.name as user_name, u.email as user_email
            FROM orders o
            JOIN users u ON o.user_id = u.id
            ORDER BY o.created_at DESC
        `);
        res.json(result.rows);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

// Get order by ID with items
router.get('/:id', async (req, res) => {
    try {
        // Get order details
        const orderResult = await db.query(`
            SELECT o.*, u.name as user_name, u.email as user_email
            FROM orders o
            JOIN users u ON o.user_id = u.id
            WHERE o.id = $1
        `, [req.params.id]);

        if (orderResult.rows.length === 0) {
            return res.status(404).json({ message: 'Order not found' });
        }

        // Get order items
        const itemsResult = await db.query(`
            SELECT oi.*, p.name as product_name, p.description as product_description
            FROM order_items oi
            JOIN products p ON oi.product_id = p.id
            WHERE oi.order_id = $1
        `, [req.params.id]);

        const order = orderResult.rows[0];
        order.items = itemsResult.rows;

        res.json(order);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

// Create new order
router.post('/', async (req, res) => {
    const { user_id, items } = req.body;
    
    try {
        await db.query('BEGIN');

        // Calculate total amount
        let total_amount = 0;
        for (const item of items) {
            const productResult = await db.query('SELECT price FROM products WHERE id = $1', [item.product_id]);
            if (productResult.rows.length === 0) {
                throw new Error(`Product ${item.product_id} not found`);
            }
            total_amount += productResult.rows[0].price * item.quantity;
        }

        // Create order
        const orderResult = await db.query(
            'INSERT INTO orders (user_id, total_amount) VALUES ($1, $2) RETURNING *',
            [user_id, total_amount]
        );

        // Create order items
        for (const item of items) {
            await db.query(
                'INSERT INTO order_items (order_id, product_id, quantity, price_at_time) VALUES ($1, $2, $3, $4)',
                [orderResult.rows[0].id, item.product_id, item.quantity, item.price]
            );

            // Update product stock
            await db.query(
                'UPDATE products SET stock_quantity = stock_quantity - $1 WHERE id = $2',
                [item.quantity, item.product_id]
            );
        }

        await db.query('COMMIT');
        res.status(201).json(orderResult.rows[0]);
    } catch (err) {
        await db.query('ROLLBACK');
        res.status(500).json({ error: err.message });
    }
});

module.exports = router; 