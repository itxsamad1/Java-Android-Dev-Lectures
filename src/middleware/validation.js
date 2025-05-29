const validateUser = (req, res, next) => {
    const { name, email, password } = req.body;
    const errors = [];

    if (!name || name.length < 3) {
        errors.push('Name must be at least 3 characters long');
    }

    if (!email || !email.match(/^[^\s@]+@[^\s@]+\.[^\s@]+$/)) {
        errors.push('Please provide a valid email address');
    }

    if (!password || password.length < 6) {
        errors.push('Password must be at least 6 characters long');
    }

    if (errors.length > 0) {
        return res.status(400).json({ errors });
    }

    next();
};

const validateProduct = (req, res, next) => {
    const { name, price, stock_quantity } = req.body;
    const errors = [];

    if (!name || name.length < 3) {
        errors.push('Product name must be at least 3 characters long');
    }

    if (!price || isNaN(price) || price <= 0) {
        errors.push('Please provide a valid price');
    }

    if (!stock_quantity || isNaN(stock_quantity) || stock_quantity < 0) {
        errors.push('Please provide a valid stock quantity');
    }

    if (errors.length > 0) {
        return res.status(400).json({ errors });
    }

    next();
};

const validateOrder = (req, res, next) => {
    const { user_id, items } = req.body;
    const errors = [];

    if (!user_id || isNaN(user_id)) {
        errors.push('Please provide a valid user ID');
    }

    if (!Array.isArray(items) || items.length === 0) {
        errors.push('Order must contain at least one item');
    } else {
        items.forEach((item, index) => {
            if (!item.product_id || !item.quantity || item.quantity <= 0) {
                errors.push(`Invalid item at position ${index + 1}`);
            }
        });
    }

    if (errors.length > 0) {
        return res.status(400).json({ errors });
    }

    next();
};

module.exports = {
    validateUser,
    validateProduct,
    validateOrder
}; 