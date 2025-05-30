# SMIU API with Neon PostgreSQL

This project demonstrates the setup and implementation of a RESTful API using Node.js, Express.js, and Neon PostgreSQL database. The API provides endpoints to interact with the SMIU database.

## Project Setup Steps

### 1. Database Setup with Neon PostgreSQL
1. Sign up for Neon PostgreSQL using GitHub authentication
2. Create a new project named "SMIU"
3. Create necessary database tables (e.g., teacher table)
4. Insert dummy data into the tables for testing

#### Database Schema and Data
Below are the SQL queries used to create the database schema and insert initial data:

```sql
-- Create Teacher table
CREATE TABLE Teacher(
  TID serial primary key,
  TName varchar(28) not null
);

-- Create Student table
CREATE TABLE Student(
  SID serial primary key,
  SName varchar(28) not null,
  SEmail varchar(100) unique,
  Address varchar(150) not null
);

-- Create Course table
CREATE TABLE Course(
  Course_Code varchar(6) primary key,
  CName varchar(28) not null
);

-- Create Enrollment table (Many-to-Many relationship between Student and Course)
CREATE TABLE Enrollment(
  Course_code varchar(6) references course(Course_code),
  SID int references Student(SID),
  primary key(Course_code,SID)
);

-- Create Teaches table (Many-to-Many relationship between Teacher and Course)
CREATE TABLE Teaches(
  Course_code varchar(6) references course(Course_code),
  TID int references Teacher(TID),
  primary key(Course_code,TID)
);

-- Insert sample student data
INSERT INTO Student (SName, SEmail, Address) VALUES
('Ali Khan', 'ali.khan@example.com', 'Karachi, Pakistan'),
('Sara Ahmed', 'sara.ahmed@example.com', 'Lahore, Pakistan'),
('Usman Tariq', 'usman.tariq@example.com', 'Islamabad, Pakistan'),
('Fatima Noor', 'fatima.noor@example.com', 'Peshawar, Pakistan'),
('Bilal Saeed', 'bilal.saeed@example.com', 'Quetta, Pakistan'),
('Ayesha Iqbal', 'ayesha.iqbal@example.com', 'Multan, Pakistan'),
('Hamza Raza', 'hamza.raza@example.com', 'Faisalabad, Pakistan'),
('Nida Zahid', 'nida.zahid@example.com', 'Rawalpindi, Pakistan'),
('Zain Ali', 'zain.ali@example.com', 'Hyderabad, Pakistan'),
('Mariam Khan', 'mariam.khan@example.com', 'Sialkot, Pakistan');

-- Insert sample teacher data
INSERT INTO Teacher (TName) VALUES
('Dr. Asim Shah'),
('Prof. Nadia Khan'),
('Dr. Bilal Hashmi'),
('Ms. Saba Noor'),
('Dr. Zeeshan Ali'),
('Mr. Kamran Qureshi'),
('Dr. Hina Tariq'),
('Prof. Waqar Zia'),
('Ms. Anum Rafiq'),
('Dr. Fahad Rehman');

-- Insert sample course data
INSERT INTO Course (Course_Code, CName) VALUES
('CS101', 'Intro to CS'),
('CS102', 'Data Structures'),
('CS103', 'Databases'),
('CS104', 'Web Dev'),
('CS105', 'AI Basics'),
('CS106', 'OOP Concepts'),
('CS107', 'Computer Networks'),
('CS108', 'Operating Systems'),
('CS109', 'Machine Learning'),
('CS110', 'Software Engg');
```

### 2. Project Structure
```
SMIUAPI/
├── WEBAPI/
│   ├── node_modules/
│   ├── index.js         # Main server file
│   ├── db.js           # Database configuration
│   ├── package.json    # Project dependencies
│   └── .env           # Environment variables (not in repo)
```

### 3. Dependencies

#### Core Dependencies
- **Node.js**
  - JavaScript runtime environment
  - Allows running JavaScript code outside the browser
  - Provides the foundation for server-side development
  - Used for executing the backend application

- **Express.js**
  - Fast, unopinionated web framework for Node.js
  - Handles routing, middleware, and HTTP request/response
  - Makes it easier to create REST APIs
  - Provides robust set of features for web applications

#### Database Related
- **pg (node-postgres)**
  - PostgreSQL client for Node.js
  - Manages database connections and queries
  - Provides connection pooling for better performance
  - Supports both callbacks and promises

#### Middleware and Utilities
- **cors**
  - Cross-Origin Resource Sharing middleware
  - Enables secure cross-origin requests
  - Essential for web APIs accessible from different domains
  - Helps in handling browser security restrictions

- **dotenv**
  - Loads environment variables from .env file
  - Keeps sensitive data secure (like database credentials)
  - Separates configuration from code
  - Essential for managing different environments (development/production)

### 4. Installation
1. Clone the repository
```bash
git clone <repository-url>
cd SMIUAPI/WEBAPI
```

2. Install dependencies
```bash
npm install
```

3. Create a `.env` file in the WEBAPI directory with the following content:
```
DATABASE_URL=your_neon_postgresql_connection_string
PORT=8090
```

4. Start the server
```bash
node index.js
```

### 5. API Endpoints

1. Test Endpoint
- URL: `/`
- Method: GET
- Description: Test endpoint to verify API is working
- Response: `{"Message": "AOA, WELCOME TO SMIU...."}`

2. Teachers Endpoint
- URL: `/teacher`
- Method: GET
- Description: Retrieves all teachers from the database
- Response: Array of teacher objects

### 6. Code Structure

#### index.js
- Main server file
- Sets up Express server
- Configures middleware (cors)
- Defines API endpoints
- Handles error responses

#### db.js
- Database configuration
- Sets up connection pool to Neon PostgreSQL
- Handles SSL configuration for secure connection

### 7. Important Notes
- The API uses connection pooling for efficient database connections
- CORS is enabled for cross-origin requests
- Error handling is implemented for all endpoints
- SSL is configured for secure database connection
- Environment variables are used for sensitive information

### 8. Testing
You can test the API endpoints using:
- Web browser
- Postman
- cURL commands

Example cURL commands:
```bash
# Test endpoint
curl http://localhost:8090/

# Get all teachers
curl http://localhost:8090/teacher
```