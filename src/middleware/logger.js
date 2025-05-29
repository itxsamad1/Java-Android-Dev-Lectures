const fs = require('fs');
const path = require('path');

// Ensure logs directory exists
const logsDir = path.join(__dirname, '../logs');
if (!fs.existsSync(logsDir)) {
    fs.mkdirSync(logsDir);
}

const logStream = fs.createWriteStream(
    path.join(logsDir, 'api.log'),
    { flags: 'a' }
);

const logger = (req, res, next) => {
    const start = new Date();
    const { method, url, body, query } = req;

    // Log request
    const requestLog = {
        timestamp: start.toISOString(),
        method,
        url,
        body,
        query,
        headers: req.headers
    };

    logStream.write(`\n[REQUEST] ${JSON.stringify(requestLog)}\n`);

    // Capture response using response event listener
    const oldWrite = res.write;
    const oldEnd = res.end;
    const chunks = [];

    res.write = function (chunk) {
        chunks.push(chunk);
        return oldWrite.apply(res, arguments);
    };

    res.end = function (chunk) {
        if (chunk) {
            chunks.push(chunk);
        }

        const responseBody = Buffer.concat(chunks).toString('utf8');
        const responseLog = {
            timestamp: new Date().toISOString(),
            method,
            url,
            statusCode: res.statusCode,
            responseTime: `${new Date() - start}ms`,
            response: responseBody
        };

        logStream.write(`[RESPONSE] ${JSON.stringify(responseLog)}\n`);
        oldEnd.apply(res, arguments);
    };

    next();
};

const errorLogger = (err, req, res, next) => {
    const errorLog = {
        timestamp: new Date().toISOString(),
        error: {
            message: err.message,
            stack: err.stack,
            code: err.code
        },
        request: {
            method: req.method,
            url: req.url,
            body: req.body,
            query: req.query
        }
    };

    logStream.write(`[ERROR] ${JSON.stringify(errorLog)}\n`);
    next(err);
};

module.exports = {
    logger,
    errorLogger
}; 