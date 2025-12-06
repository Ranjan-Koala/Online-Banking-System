# Online-Banking-System
The Online Banking System is a Java-based application built with JDBC, Hibernate, Maven, and MySQL. It supports customer creation, account management, balance updates, and secure fund transfers. Combining direct SQL with ORM, it offers a clean, modular structure ideal for learning backend banking workflows.

## 🛠️ Tech Stack Used
### 1. Java

- Core programming language

- Implements OOP principles: Classes, Objects, Encapsulation

- Business logic for all banking operations

### 2. Hibernate ORM

- Used for Account, Customer, and TransactionRecord persistence

- Handles CRUD operations without writing SQL

- Supports HQL, session management, and automatic dirty checking

- Manages commit/rollback of transactions

### 3. JDBC (Optional)

- Demonstrates direct SQL connectivity

- Shows hybrid architecture (Hibernate + JDBC)

### 4. MySQL

- Stores customers, accounts, and transaction history

- Relational database with foreign keys

- Ensures structured data storage

### 5. Maven

- Build and dependency management

- Automatically manages Hibernate, MySQL driver, logging libraries

## ✨ Features
### 1. Customer Management

Create new customers with:

- Name

- Email

- Phone

- Address

- Government ID Type (PAN, AADHAAR, Driving License)

- Government ID Number

- Auto-generated Customer ID

- Validations for missing or incorrect details

### 2. Account Management

- Create new bank accounts linked to existing customers

- Each account contains:

- Unique Account Number

- Auto-generated Account ID

- Customer reference

- Account balance

- Creation timestamp

- Validates Customer ID before account creation

### 3. Deposit & Withdrawal

- Deposit money using Account ID

- Withdraw money with balance validation

- Automatic balance updates using Hibernate’s persistent state

- Error shown if insufficient balance for withdrawal

### 4. Fund Transfer

- Transfer money between two accounts

Checks:

- Account existence

- Sufficient balance

- Auto-generates transaction record

- Rollback on failure (Hibernate transaction management)

### 5. Transaction Logging

- Stores every fund transfer as a record

Includes:

- Source account

- Destination account

- Amount

- Type (TRANSFER)

- Timestamp

### 6. Search Functionality

- Find account details using Account ID

- Find account ID using Account Number (new feature)

- Useful for quick account lookup

### 7. Error Handling

Handles:

- Account not found

- Customer not found

- Insufficient balance

- Invalid inputs

- Clean and understandable error messages

### 8. Modular Architecture

- DAO layer for database access

- Service layer for business logic

- Utility layer for Hibernate/JDBC connection management

- Clean folder structure for easy maintenance
