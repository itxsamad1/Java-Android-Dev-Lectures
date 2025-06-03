// Import the Pool class from the 'pg' (PostgreSQL) package
// Pool manages a collection of database connections for better performance
const { Pool } = require('pg');

// Load environment variables from .env file
// This allows us to keep sensitive data like database credentials secure
require('dotenv').config();

// Create a new connection pool
// This will manage multiple database connections efficiently
const pool = new Pool({
    // Use the connection string from environment variables
    // This string contains all database connection details (host, port, credentials, etc.)
    connectionString:process.env.DATABASE_URL,
    // SSL configuration for secure connection
    ssl:{
        // Don't reject unauthorized connections
        // This is often needed for cloud database services like Neon
        rejectUnauthorized:false
    }
});

// Export the pool object so other files can use it
// This allows us to reuse the same database connection pool across the application
module.exports = pool;