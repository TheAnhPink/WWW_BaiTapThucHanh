# Product Management System

A Spring Boot application for managing products with role-based access control using Spring Security.

## Features

- **Product Management**: CRUD operations for products
- **Role-based Access Control**:
  - **ADMIN**: Full access to all CRUD operations
  - **CUSTOMER**: Read-only access to view products
- **Database**: MariaDB integration with Spring JPA
- **Frontend**: Thymeleaf templates with Bootstrap styling
- **Security**: Spring Security with form-based authentication

## Technology Stack

- Java 21
- Spring Boot 3.5.6
- Spring Security
- Spring Data JPA
- MariaDB
- Thymeleaf
- Bootstrap 5
- Lombok

## Setup Instructions

### 1. Database Setup

Create a MariaDB database named `productmanagement`:

```sql
CREATE DATABASE productmanagement;
```

### 2. Configuration

Update `src/main/resources/application.properties` with your database credentials:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/productmanagement
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## Default Users

### Admin Account
- **Username**: admin
- **Password**: admin123
- **Role**: ADMIN (Full CRUD access)

### Customer Account
- **Username**: customer
- **Password**: customer123
- **Role**: CUSTOMER (Read-only access)

## Project Structure

```
src/main/java/fit/se/demospringsecurity2/
├── config/
│   └── SecurityConfig.java          # Security configuration
├── controller/
│   ├── HomeController.java          # Home and login controller
│   └── ProductController.java       # Product CRUD controller
├── entity/
│   └── Product.java                 # Product entity
├── repository/
│   └── ProductRepository.java       # Product repository
└── service/
    └── ProductService.java          # Product business logic

src/main/resources/templates/
├── layout.html                      # Base template
├── login.html                       # Login page
└── products/
    ├── list.html                    # Product list
    ├── view.html                    # Product details
    ├── add.html                     # Add product form
    └── edit.html                    # Edit product form
```

## API Endpoints

| Method | Endpoint | Description | Access |
|--------|----------|-------------|---------|
| GET | `/` | Redirect to products | All authenticated users |
| GET | `/login` | Login page | Anonymous |
| GET | `/products` | List all products | All authenticated users |
| GET | `/products/view/{id}` | View product details | All authenticated users |
| GET | `/products/add` | Add product form | ADMIN only |
| POST | `/products/add` | Create product | ADMIN only |
| GET | `/products/edit/{id}` | Edit product form | ADMIN only |
| POST | `/products/edit` | Update product | ADMIN only |
| GET | `/products/delete/{id}` | Delete product | ADMIN only |

## Security Features

- Form-based authentication
- Role-based authorization
- Password encryption using BCrypt
- CSRF protection
- Session management

## Development

### Adding New Features

1. Create entity classes in the `entity` package
2. Create repository interfaces extending `JpaRepository`
3. Create service classes for business logic
4. Create controller classes for handling HTTP requests
5. Create Thymeleaf templates in the `templates` directory

### Database Schema

The `products` table will be automatically created with the following structure:

```sql
CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL,
    image_url VARCHAR(500)
);
```

