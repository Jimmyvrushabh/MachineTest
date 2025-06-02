# 🚀 MachineTest API Suite

Welcome to the **MachineTest** backend project – a powerful Spring Boot application designed for handling **Product** and **Category** operations through RESTful APIs.

This project showcases a clean and scalable implementation using Spring Boot, JPA, Hibernate, and pagination — perfect for real-world enterprise use cases.

---

## 🧰 Tech Stack

- **Spring Boot** – Rapid application development
- **Spring Data JPA + Hibernate** – ORM & DB access
- **MySQL/PostgreSQL** – Relational Database (RDB)
- **RESTful API** – Clean, scalable HTTP endpoints
- **Maven** – Build & Dependency Management
- **Java 11+**

---

## 🎯 Project Objectives

| Requirement                 | Status     |
|----------------------------|------------|
| ✅ Spring Boot              | Implemented |
| ✅ REST Controller          | Implemented |
| ✅ Annotation Configuration | Implemented |
| ✅ RDB Setup (Not H2)       | Configurable |
| ✅ JPA & Hibernate ORM      | Enabled |
| ✅ Pagination Support       | Added |

---

## 📦 API Modules

### 📁 Category Module

| Method | Endpoint                                       | Description              |
|--------|------------------------------------------------|--------------------------|
| GET    | `/api/categories?page=3`                       | Get all categories (paginated) |
| POST   | `/api/categories`                              | Create a new category    |
| GET    | `/api/categories/{id}`                         | Get category by ID       |
| PUT    | `/api/categories/{id}`                         | Update category by ID    |
| DELETE | `/api/categories/{id}`                         | Delete category by ID    |




### 📦 Product API Endpoints

| Method | Endpoint                 | Description               |
|--------|--------------------------|---------------------------|
| GET    | `/api/products?page=2`   | Get all products (paginated) |
| POST   | `/api/products`          | Create a new product      |
| GET    | `/api/products/{id}`     | Get product by ID         |
| PUT    | `/api/products/{id}`     | Update product by ID      |
| DELETE | `/api/products/{id}`     | Delete product by ID      |


#### 🧪 Sample Category JSON

```json
{
  "categoryName": "Footwear"
}



####🧪 Sample Product JSON
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



---

## 📬 Contact

👨‍💻 **Vrushabh C**

- ✉️ **Email**: [vrushabhc1234@gmail.com](mailto:vrushabhc1234@gmail.com)
- 🔗 **GitHub**: [github.com/Jimmyvrushabh](https://github.com/Jimmyvrushabh)

Feel free to reach out for collaboration, suggestions, or just to say hello! 😊
