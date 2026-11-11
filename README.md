# Shopify Product API

> A clean and lightweight Spring Boot REST API for creating and storing
> products in MySQL.

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-6DB33F?logo=springboot&logoColor=white)
![Database](https://img.shields.io/badge/Database-MySQL-4479A1?logo=mysql&logoColor=white)
![Build](https://img.shields.io/badge/Build-Maven-C71A36?logo=apachemaven&logoColor=white)

## Overview

Shopify Product API provides a simple backend for adding products to an
e-commerce catalog. It validates incoming data, persists products with Spring
Data JPA, and returns the created product with generated metadata.

## Features

| Capability | Description |
| --- | --- |
| Product creation | Add products through a REST endpoint |
| Request validation | Enforce required fields, ranges, and length limits |
| Persistence | Store products with Spring Data JPA and Hibernate |
| Response mapping | Return the product ID and creation/update timestamps |

## Tech stack

| Technology | Version / purpose |
| --- | --- |
| Java | 21 |
| Spring Boot | 4.1.2 |
| Spring Web MVC | REST API |
| Spring Data JPA | Persistence |
| MySQL | Relational database |
| Maven Wrapper | Build and run tooling |

## Project structure

```text
shopify/
├── src/main/java/com/shubham/shopify/
│   ├── Controller/       # REST controllers
│   ├── Dto/              # Request and response DTOs
│   ├── Entity/           # JPA entities
│   ├── Repository/       # Data access interfaces
│   └── Service/          # Application services
├── src/main/resources/
│   └── application.properties
├── src/test/
├── pom.xml
├── mvnw
└── mvnw.cmd
```

## Getting started

### Prerequisites

- JDK 21 or later
- MySQL running locally
- A MySQL database named `Product_crud_db`

Create the database:

```sql
CREATE DATABASE Product_crud_db;
```

### Configure the database

The application reads its database settings from
`src/main/resources/application.properties`.

Update the datasource credentials for your local MySQL installation:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/Product_crud_db
spring.datasource.username=root
spring.datasource.password=<your-password>
```

Hibernate uses `ddl-auto=update`, so the `Product` table is created or updated
automatically when the application starts.

### Start the API

From the `shopify` directory:

**Windows**

```powershell
.\mvnw.cmd spring-boot:run
```

**macOS/Linux**

```bash
./mvnw spring-boot:run
```

The API starts on `http://localhost:8080`.

## API reference

### Create a product

```http
POST /Shopify/api/product/addProduct
Content-Type: application/json
```

Example request:

```json
{
  "product_name": "Wireless Keyboard",
  "price": 2499,
  "category": "Accessories",
  "description": "A compact wireless keyboard for everyday work"
}
```

Example response (`201 Created`):

```json
{
  "id": 1,
  "product_name": "Wireless Keyboard",
  "price": 2499,
  "category": "Accessories",
  "description": "A compact wireless keyboard for everyday work",
  "created_time": "2026-11-11T12:00:00",
  "updated_time": "2026-11-11T12:00:00"
}
```

**Windows PowerShell**

```powershell
$body = @{
  product_name = "Wireless Keyboard"
  price = 2499
  category = "Accessories"
  description = "A compact wireless keyboard for everyday work"
} | ConvertTo-Json

Invoke-RestMethod `
  -Uri "http://localhost:8080/Shopify/api/product/addProduct" `
  -Method Post `
  -ContentType "application/json" `
  -Body $body
```

**macOS/Linux**

```bash
curl -X POST http://localhost:8080/Shopify/api/product/addProduct \
  -H "Content-Type: application/json" \
  -d '{"product_name":"Wireless Keyboard","price":2499,"category":"Accessories","description":"A compact wireless keyboard for everyday work"}'
```

### Validation rules

| Field | Rules |
| --- | --- |
| `product_name` | Must not be blank |
| `price` | Must be between `1` and `1,000,000` |
| `category` | Required; 4–25 characters |
| `description` | Required; 15–50 characters |

## Development

Run the test suite from the `shopify` directory:

**Windows**

```powershell
.\mvnw.cmd test
```

**macOS/Linux**

```bash
./mvnw test
```

## Notes

- The API currently exposes product creation only.
- Keep database credentials local and do not commit them.
- SQL logging is enabled in the default development configuration.
