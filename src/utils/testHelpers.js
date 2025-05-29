const db = require('../config/db.config');

const clearDatabase = async () => {
    await db.query('BEGIN');
    try {
        await db.query('DELETE FROM order_items');
        await db.query('DELETE FROM orders');
        await db.query('DELETE FROM products');
        await db.query('DELETE FROM users');
        await db.query('COMMIT');
    } catch (err) {
        await db.query('ROLLBACK');
        throw err;
    }
};

const seedTestData = async () => {
    await db.query('BEGIN');
    try {
        // Create test user
        const userResult = await db.query(
            'INSERT INTO users (name, email, password) VALUES ($1, $2, $3) RETURNING id',
            ['Test User', 'test@example.com', 'password123']
        );
        const userId = userResult.rows[0].id;

        // Create test products
        const product1Result = await db.query(
            'INSERT INTO products (name, description, price, stock_quantity) VALUES ($1, $2, $3, $4) RETURNING id',
            ['Test Product 1', 'Description 1', 99.99, 10]
        );
        const product2Result = await db.query(
            'INSERT INTO products (name, description, price, stock_quantity) VALUES ($1, $2, $3, $4) RETURNING id',
            ['Test Product 2', 'Description 2', 149.99, 5]
        );

        // Create test order
        const orderResult = await db.query(
            'INSERT INTO orders (user_id, total_amount, status) VALUES ($1, $2, $3) RETURNING id',
            [userId, 249.98, 'pending']
        );
        const orderId = orderResult.rows[0].id;

        // Create test order items
        await db.query(
            'INSERT INTO order_items (order_id, product_id, quantity, price_at_time) VALUES ($1, $2, $3, $4)',
            [orderId, product1Result.rows[0].id, 1, 99.99]
        );
        await db.query(
            'INSERT INTO order_items (order_id, product_id, quantity, price_at_time) VALUES ($1, $2, $3, $4)',
            [orderId, product2Result.rows[0].id, 1, 149.99]
        );

        await db.query('COMMIT');
        return {
            userId,
            productIds: [product1Result.rows[0].id, product2Result.rows[0].id],
            orderId
        };
    } catch (err) {
        await db.query('ROLLBACK');
        throw err;
    }
};

const generateTestToken = (userId) => {
    // This is a mock function - in a real app, use JWT or other token generation
    return `test-token-${userId}`;
};

module.exports = {
    clearDatabase,
    seedTestData,
    generateTestToken
}; 