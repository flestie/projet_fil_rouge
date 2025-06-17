# 📚 Library Management System – Java & MySQL

This project is a simple library/book management application built with Java and backed by a MySQL database.

---

## 🔧 Prerequisites

- Java 21
- MySQL Connector/J
- JUnit (your preferred version)

---

## 🚀 Key Features

- Add a book (with duplicate check)
- Remove a book
- Update the price or image of a book
- Display all books
- Count total books in the database

---

## 🧱 Project Structure

### Example from the DAO (`BookDao.java`)

```java
BookDao dao = new BookDao();
Book book = new Book("Title", "Author", ...);
dao.addBook(book);
