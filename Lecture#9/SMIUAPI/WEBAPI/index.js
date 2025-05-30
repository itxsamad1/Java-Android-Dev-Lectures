// Import required packages/modules
// express: Web framework for creating the server and handling HTTP requests
const express = require('express');
// cors: Middleware to enable Cross-Origin Resource Sharing (allows requests from different domains)
const cors = require('cors');
// pool: Database connection pool from our db.js file
const pool = require('./db');
// dotenv: Package to load environment variables from .env file
require('dotenv').config();

// Create an Express application instance
const app = express();

// Set up middleware
// Enable CORS for all routes
app.use(cors());
// Parse JSON bodies in requests
app.use(express());

// Define Routes

// Route 1: Test endpoint at root URL '/'
// async/await is used for handling asynchronous operations
app.get('/',async(req,res)=>{
    try{
        // Send a JSON response with a welcome message
        // req: contains information about the HTTP request
        // res: used to send back the HTTP response
        res.json({Message:"AOA, WELCOME TO SMIU...."});
    }catch(err){
        // If any error occurs, send a 500 (Server Error) response
        // with the error message in JSON format
        res.status(500).json({Error:err.message});
    }
});

// Route 2: Teacher endpoint at '/teacher'
app.get('/teacher',async(req,res)=>{
    try{
        // Execute a SQL query to select all records from teacher table
        // await: waits for the query to complete before moving on
        const output = await pool.query('select * from teacher');
        // Send the query results (rows) back as JSON response
        res.json(output.rows);
    }catch(err){
        // Handle any errors that occur during the database query
        res.status(500).json({Error:err.message});
    }
});

// Set up the server port
// Use the PORT from environment variables if available, otherwise use 8090
const PORT = process.env.PORT | 8090;

// Start the server and listen for incoming requests
app.listen(PORT,()=>{
    // Callback function that runs when server starts successfully
    console.log(`Connect Successfully... Running on Port ${PORT}`);
});
