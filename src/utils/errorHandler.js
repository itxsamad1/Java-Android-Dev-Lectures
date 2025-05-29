class AppError extends Error {
    constructor(message, statusCode) {
        super(message);
        this.statusCode = statusCode;
        this.status = `${statusCode}`.startsWith('4') ? 'fail' : 'error';
        this.isOperational = true;

        Error.captureStackTrace(this, this.constructor);
    }
}

const handleDatabaseError = (err) => {
    // Handle unique violation
    if (err.code === '23505') {
        return new AppError('Duplicate entry: This record already exists', 400);
    }

    // Handle foreign key violation
    if (err.code === '23503') {
        return new AppError('Invalid reference: The referenced record does not exist', 400);
    }

    // Handle not null violation
    if (err.code === '23502') {
        return new AppError('Missing required field', 400);
    }

    return new AppError('Database error occurred', 500);
};

const errorHandler = (err, req, res, next) => {
    err.statusCode = err.statusCode || 500;
    err.status = err.status || 'error';

    if (process.env.NODE_ENV === 'development') {
        res.status(err.statusCode).json({
            status: err.status,
            error: err,
            message: err.message,
            stack: err.stack
        });
    } else {
        // Production error response
        if (err.isOperational) {
            res.status(err.statusCode).json({
                status: err.status,
                message: err.message
            });
        } else {
            console.error('ERROR 💥', err);
            res.status(500).json({
                status: 'error',
                message: 'Something went wrong!'
            });
        }
    }
};

module.exports = {
    AppError,
    handleDatabaseError,
    errorHandler
}; 