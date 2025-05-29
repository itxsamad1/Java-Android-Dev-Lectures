# SMIU API Documentation

## Base URL
```
http://your-api-url:3000/api
```

## Authentication
Currently, the API does not require authentication. This will be implemented in future versions.

## Error Handling
All endpoints follow the same error response format:

```json
{
    "status": "error",
    "message": "Error description"
}
```

## Endpoints

### Users

#### GET /users
Get all users

Response:
```json
[
    {
        "id": 1,
        "name": "John Doe",
        "email": "john@example.com",
        "created_at": "2024-01-20T12:00:00Z"
    }
]
```

#### POST /users
Create a new user

Request:
```json
{
    "name": "John Doe",
    "email": "john@example.com",
    "password": "password123"
}
```

### Products

#### GET /products
Get all products

Response:
```json
[
    {
        "id": 1,
        "name": "Product 1",
        "description": "Description",
        "price": 99.99,
        "stock_quantity": 100
    }
]
```

#### POST /products
Create a new product

Request:
```json
{
    "name": "Product 1",
    "description": "Description",
    "price": 99.99,
    "stock_quantity": 100
}
```

### Orders

#### POST /orders
Create a new order

Request:
```json
{
    "user_id": 1,
    "items": [
        {
            "product_id": 1,
            "quantity": 2
        }
    ]
}
```

Response:
```json
{
    "id": 1,
    "user_id": 1,
    "total_amount": 199.98,
    "status": "pending",
    "created_at": "2024-01-20T12:00:00Z"
}
```

## Error Codes

- 400: Bad Request - Invalid input
- 404: Not Found - Resource doesn't exist
- 500: Internal Server Error - Something went wrong on the server 