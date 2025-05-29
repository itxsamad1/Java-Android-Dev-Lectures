# Lecture #9: Backend and Database Integration

## Overview
This lecture covers the implementation of a backend server using Node.js, Express.js, and PostgreSQL database hosted on Neon. We'll create a RESTful API that can be consumed by our Android application.

## Technologies Used
- Node.js - Runtime environment
- Express.js - Web application framework
- PostgreSQL - Database system
- Neon - Cloud PostgreSQL service
- Postman - API testing tool

## Project Structure
```
Lecture#9/
├── src/
│   ├── config/
│   │   └── db.config.js
│   ├── routes/
│   │   └── api.routes.js
│   ├── controllers/
│   │   └── user.controller.js
│   ├── models/
│   │   └── user.model.js
│   └── server.js
├── postman/
│   └── SMIU_API.postman_collection.json
└── README.md
```

## Setup Instructions

1. Install Node.js from [nodejs.org](https://nodejs.org/)

2. Install project dependencies:
```bash
cd Lecture#9
npm init -y
npm install express pg dotenv cors
```

3. Create a `.env` file with your Neon database credentials:
```env
DB_HOST=your-neon-host
DB_USER=your-username
DB_PASSWORD=your-password
DB_NAME=your-database
DB_PORT=5432
```

4. Run the server:
```bash
node src/server.js
```

## Database Schema
We'll implement the following tables:
- Users
- Products
- Orders

Detailed schema will be provided in the database setup section.

## API Endpoints
The following endpoints will be implemented:

### Users
- GET /api/users - Get all users
- POST /api/users - Create new user
- GET /api/users/:id - Get user by ID
- PUT /api/users/:id - Update user
- DELETE /api/users/:id - Delete user

### Products
- GET /api/products - Get all products
- POST /api/products - Add new product
- GET /api/products/:id - Get product by ID

### Orders
- GET /api/orders - Get all orders
- POST /api/orders - Create new order
- GET /api/orders/:id - Get order details

## Testing
- Import the Postman collection from the `postman` directory
- Update the environment variables in Postman
- Run the requests to test each endpoint

## Integration with Android
Instructions for integrating this API with your Android application will be covered in the implementation section. 