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
#### 1. Customer Management

Create new customers with:

- Name

- Email

- Phone

- Address

- Government ID Type (PAN, AADHAAR, Driving License)

- Government ID Number

- Auto-generated Customer ID

- Validations for missing or incorrect details

#### 2. Account Management

- Create new bank accounts linked to existing customers

- Each account contains:

- Unique Account Number

- Auto-generated Account ID

- Customer reference

- Account balance

- Creation timestamp

- Validates Customer ID before account creation

#### 3. Deposit & Withdrawal

- Deposit money using Account ID

- Withdraw money with balance validation

- Automatic balance updates using Hibernate’s persistent state

- Error shown if insufficient balance for withdrawal

#### 4. Fund Transfer

- Transfer money between two accounts

Checks:

- Account existence

- Sufficient balance

- Auto-generates transaction record

- Rollback on failure (Hibernate transaction management)

#### 5. Transaction Logging

- Stores every fund transfer as a record

Includes:

- Source account

- Destination account

- Amount

- Type (TRANSFER)

- Timestamp

#### 6. Search Functionality

- Find account details using Account ID

- Find account ID using Account Number (new feature)

- Useful for quick account lookup

#### 7. Error Handling

Handles:

- Account not found

- Customer not found

- Insufficient balance

- Invalid inputs

- Clean and understandable error messages

#### 8. Modular Architecture

- DAO layer for database access

- Service layer for business logic

- Utility layer for Hibernate/JDBC connection management

- Clean folder structure for easy maintenance

## 📂 Project Structure
<img width="892" height="628" alt="image" src="https://github.com/user-attachments/assets/9d6bde56-2cf2-4f20-bf32-b0c9a6cdf6f7" />

## 📘 User Guide
#### ▶️ Start Application

Run:

App.java


Menu appears:

1. Create Customer
2. Create Account
3. Deposit Money
4. Withdraw Money
5. Transfer Funds
6. View Account Details
7. Find Account ID by Account Number
8. Exit

#### ▶️ 1. Create Customer

Enter:

Name

Email

Phone

Address

ID Type

ID Number

Output:

Customer created with ID: 1

#### ▶️ 2. Create Account

Enter:

Account Number

Customer ID

Output:

Account created with ID: 10

#### ▶️ 3. Deposit

Enter:

Account ID

Amount

#### ▶️ 4. Withdraw

Enter:

Account ID

Amount

If insufficient:

❌ Insufficient balance

#### ▶️ 5. Transfer Funds

Enter:

From Account ID

To Account ID

Amount

If successful:

✔ Transfer completed!

#### ▶️ 6. View Account Details

Enter:

Account ID

Shows:

Account ID

Account Number

Customer Name

Balance

#### ▶️ 7. Find Account ID by Account Number

Enter:

Account Number → Account ID

## ⚙️ How to Run Locally
#### 1️⃣ Clone Repo
git clone https://github.com/<your-username>/<your-repo>.git

#### 2️⃣ Import as Maven Project

#### 3️⃣ Configure DB Credentials

- hibernate.cfg.xml

- JDBCUtil.java

#### 4️⃣ Run
App.java

## 🚀 Future Enhancements

- Add Spring Boot REST APIs

- Add user authentication

- Add account statements

- Add email/SMS notifications

- Add admin dashboard

## ❤️ Contributions

_ Pull requests are welcome!

