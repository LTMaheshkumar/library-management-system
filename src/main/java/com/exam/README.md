📚 Library Management System – Spring Boot (CRUD Project)

A simple and clean Library Management System built using Spring Boot, following REST API standards and layered architecture.

🚀 Features
✔ Book Management

Add Book

Update Book

Delete Book

Fetch All Books

✔ Author Management

Add Author

Update Author

Delete Author

Fetch All Authors

🧱 Tech Stack
Layer	Technology
Backend	Spring Boot, Spring Web
Database	MySQL
Build Tool	Maven
Testing Tool	Postman / Swagger
Language	Java
📂 Project Structure
src/
 ├─ main/
 │   ├─ java/
 │   │   └─ com.exam
 │   │        ├─ controller
 │   │        ├─ service
 │   │        ├─ repository
 │   │        └─ dto
 │   └─ resources/
 │       ├─ application.properties






 🔗 API Endpoints (Sample)
Book APIs
Method	Endpoint	Description
POST	/books/addBook	Add new book
GET	/books	Get all books
PUT	/books/{id}	Update book
DELETE	/books/{id}	Delete book
