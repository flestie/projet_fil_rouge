DROP DATABASE if EXISTS library;
CREATE DATABASE library;
USE library;

-- Users table
CREATE TABLE user (
    id_user INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    age INT,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address TEXT,
    username VARCHAR(50) UNIQUE NOT NULL,
    profile_photo VARCHAR(255),
    preferred_language VARCHAR(50),
    role ENUM('admin', 'standard', 'authors') DEFAULT 'standard'
);

-- Books table
CREATE TABLE book (
    id_book INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100),
    publisher VARCHAR(100),
    category VARCHAR(50),
    page_count INT,
    language VARCHAR(50),
    description TEXT,
    image VARCHAR(255),
    format VARCHAR(50),
    price DECIMAL(10, 2), 
    download_count INT DEFAULT 0
);

-- Purchases table
CREATE TABLE purchase (
    id_purchase INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT NOT NULL,
    id_book INT NOT NULL,
    purchase_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    amount_paid DECIMAL(10, 2),
    payment_status ENUM('paid', 'pending', 'failed') DEFAULT 'pending',
    FOREIGN KEY (id_user) REFERENCES user(id_user),
    FOREIGN KEY (id_book) REFERENCES book(id_book)
);

-- Comments table
CREATE TABLE comment (
    id_comment INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT NOT NULL,
    id_book INT NOT NULL,
    content TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_user) REFERENCES user(id_user),
    FOREIGN KEY (id_book) REFERENCES book(id_book)
);

-- Ratings table
CREATE TABLE rating (
    id_rating INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT NOT NULL,
    id_book INT NOT NULL,
    score INT CHECK (score >= 1 AND score <= 5),
    date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_user) REFERENCES user(id_user),
    FOREIGN KEY (id_book) REFERENCES book(id_book)
);
