-- Seed Users
INSERT INTO users (name, email, password) VALUES
('John Doe', 'john@example.com', 'password123'),
('Jane Smith', 'jane@example.com', 'password456'),
('Bob Wilson', 'bob@example.com', 'password789');

-- Seed Products
INSERT INTO products (name, description, price, stock_quantity) VALUES
('Android Phone', 'Latest Android smartphone with great features', 599.99, 50),
('Wireless Earbuds', 'High-quality wireless earbuds with noise cancellation', 129.99, 100),
('Smart Watch', 'Fitness tracking smartwatch with heart rate monitor', 199.99, 75),
('Power Bank', 'High-capacity power bank for mobile devices', 49.99, 200),
('Phone Case', 'Protective case for Android phones', 19.99, 150);

-- Seed Orders
INSERT INTO orders (user_id, total_amount, status) VALUES
(1, 729.98, 'completed'),
(2, 269.97, 'pending'),
(3, 599.99, 'processing');

-- Seed Order Items
INSERT INTO order_items (order_id, product_id, quantity, price_at_time) VALUES
(1, 1, 1, 599.99),
(1, 2, 1, 129.99),
(2, 3, 1, 199.99),
(2, 4, 1, 49.99),
(2, 5, 1, 19.99),
(3, 1, 1, 599.99); 