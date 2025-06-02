# 🚀 MachineTest

Welcome to **MachineTest** Round.

Springboot api round

---

## 🌟 Features

- 🔧 Robust and scalable Spring Boot backend  
- ⚙️ Easy-to-configure and extendable modules  
- 📦 Clean project structure for faster development  
- 🚀 Ready to deploy with minimal setup


# Important Project Requirements

To ensure the project follows best practices and meets the goals, please keep in mind the following guidelines:

- **A) Use Spring Boot**  
  Develop the application using the Spring Boot framework for rapid setup and easy configuration.

- **B) Use REST Controller**  
  All APIs should be built using Spring’s `@RestController` annotation for creating RESTful web services.

- **C) Database Configuration**  
  Configure a **relational database (RDB)** such as MySQL or PostgreSQL instead of using in-memory databases like H2.  
  Make sure to set up the database connection properly.

- **D) Annotation-based Configuration**  
  Use **annotation-based configuration** exclusively (e.g., `@Configuration`, `@Bean`, `@Entity`) instead of XML configuration files.

- **E) JPA & Hibernate**  
  Use **Java Persistence API (JPA)** with **Hibernate** as the implementation for ORM (Object Relational Mapping).

- **F) Pagination**  
  Implement pagination support for API endpoints that return lists of data (e.g., categories, products), enabling efficient data retrieval in pages.

---

Following these guidelines will help you build a clean, maintainable, and production-ready Spring Boot application.


---

## 🛠️ Getting Started

Follow these simple steps to get your environment ready and run the project locally.

### Prerequisites

Make sure you have these installed:

- Java JDK 11+  
- Maven  
- Git  
- Your favorite IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)


## API Endpoints

**POST /api/products**

```json
{
  "pname": "iPhone 147 Pro",
  "pdescription": "Latest iPhone with A17 chip and titanium design",
  "brand": "Apple",
  "price": 1299.99,
  "releaseDate": "2024-09-15",
  "stockQuantity": 100,
  "categoryName": "tshirt"
}

Category -->
{
  "categoryName": "Footwear"
}



### Category CRUD Operations

| No. | Endpoint                               | HTTP Method | Description              | Notes             |
|------|--------------------------------------|-------------|--------------------------|-------------------|
| 1    | `http://localhost:8080/api/categories?page=3` | GET         | Get all categories (paged) | `page=3` means 3rd page |
| 2    | `http://localhost:8080/api/categories`          | POST        | Create a new category    |                   |
| 3    | `http://localhost:8080/api/categories/{id}`     | GET         | Get category by ID       | Replace `{id}` with actual category ID |
| 4    | `http://localhost:8080/api/categories/{id}`     | PUT         | Update category by ID    |                   |
| 5    | `http://localhost:8080/api/categories/{id}`     | DELETE      | Delete category by ID    |                   |

---

### Product CRUD Operations

| No. | Endpoint                              | HTTP Method | Description             | Notes             |
|------|-------------------------------------|-------------|-------------------------|-------------------|
| 1    | `http://localhost:8080/api/products?page=2` | GET         | Get all products (paged) | `page=2` means 2nd page |
| 2    | `http://localhost:8080/api/products`         | POST        | Create a new product    |                   |
| 3    | `http://localhost:8080/api/products/{id}`    | GET         | Get product by ID       | Replace `{id}` with actual product ID |
| 4    | `http://localhost:8080/api/products/{id}`    | PUT         | Update product by ID    |                   |
| 5    | `http://localhost:8080/api/products/{id}`    | DELETE      | Delete product by ID    |                   |




### Installation

1. **Clone the repo:**

   ```bash
   git clone https://github.com/Jimmyvrushabh/MachineTest.git

  ### 📬 Get In Touch

Questions? Feedback? Want to collaborate? Reach out to me:

**Vrushabh C**  
Email: [vrushabhc1234@gmail.com](mailto:vrushabhc1234@gmail.com)  
GitHub: [https://github.com/Jimmyvrushabh](https://github.com/Jimmyvrushabh)

