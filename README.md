# Job Companies and Reviews Microservices Architechture
## Overview

This REST API (Architechture) is designed to manage job listings and reviews for various companies. It follows a microservices architecture and is built using modern development practices to ensure scalability and maintainability. The API provides endpoints for managing companies, jobs, and reviews associated with those companies.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [API Endpoints](#api-endpoints)
  - [Company Endpoints](#company-endpoints)
  - [Job Endpoints](#job-endpoints)
  - [Review Endpoints](#review-endpoints)
- [Database Schema](#database-schema)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Company Management**: Create, read, update, and delete companies.
- **Job Management**: Create, read, update, and delete jobs for a company.
- **Review Management**: Create, read, update, and delete reviews for a company.

## Technologies Used

- **Java**: The primary programming language.
- **Spring Boot**: For building the REST API.
- **Spring Cloud Netflix Eureka**: For service registry and discovery.
- **H2-Database**: For in-memory testing purposes.
- **MySQL/PostgreSQL**: For the relational database.
- **JPA/Hibernate**: For ORM (Object-Relational Mapping).
- **Maven**: For project management and dependency management.
- **Lombok**: To reduce boilerplate code.

## Architecture

This project uses a microservices architecture where each service is responsible for a specific domain. The services communicate with each other using REST APIs and are registered with a service registry for dynamic discovery.

### Services

- **Company Service**: Manages company-related operations.
- **Job Service**: Manages job-related operations.
- **Review Service**: Manages review-related operations.
- **Service Registry**: Handles service registration and discovery.

## Getting Started

### Prerequisites

- Java 22 
- Maven
- H2-Database or MySQL or PostgreSQL database

### Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/Mansoor-P/jobsmicroservices.git
   cd jobsmicroservices
   ```

2. **Configure the databases for each service:**
  - Update the `application.properties` file in the `src/main/resources` directory of each service with your database credentials.

   Example for `company-service`:
   ```properties
   # Example for MySQL
   spring.datasource.url=jdbc:mysql://localhost:3306/companydb
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update

   # Example for PostgreSQL
   spring.datasource.url=jdbc:postgresql://localhost:5432/companydb
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build each service:**
   ```sh
   mvn clean install
   ```

4. **Run the service registry:**
   ```sh
   cd service-registry
   mvn spring-boot:run
   ```

5. **Run each service:**
   ```sh
   cd company-service
   mvn spring-boot:run

   cd ../job-service
   mvn spring-boot:run

   cd ../review-service
   mvn spring-boot:run
   ```

## API Endpoints

### Company Endpoints

- **Create Company:**
  ```http
  POST /api/v1/companies
  ```
  Creates a new company.

  **Request Body:**
  ```json
  {
    "name": "Company Name",
    "address": "Company Address",
    "email": "company@example.com"
  }
  ```

  **Response:**
  ```json
  {
    "id": 1,
    "name": "Company Name",
    "address": "Company Address",
    "email": "company@example.com"
  }
  ```

- **Get All Companies:**
  ```http
  GET /api/v1/companies
  ```
  Retrieves a list of all companies.

  **Response:**
  ```json
  [
    {
      "id": 1,
      "name": "Company Name",
      "address": "Company Address",
      "email": "company@example.com"
    },
    ...
  ]
  ```

- **Get Company by ID:**
  ```http
  GET /api/v1/companies/{companyId}
  ```
  Retrieves the details of a specific company by its ID.

  **Response:**
  ```json
  {
    "id": 1,
    "name": "Company Name",
    "address": "Company Address",
    "email": "company@example.com"
  }
  ```

- **Update Company:**
  ```http
  PUT /api/v1/companies/{companyId}
  ```
  Updates the details of a specific company by its ID.

  **Request Body:**
  ```json
  {
    "name": "Updated Company Name",
    "address": "Updated Company Address",
    "email": "updated@example.com"
  }
  ```

  **Response:**
  ```json
  {
    "id": 1,
    "name": "Updated Company Name",
    "address": "Updated Company Address",
    "email": "updated@example.com"
  }
  ```

- **Delete Company:**
  ```http
  DELETE /api/v1/companies/{companyId}
  ```
  Deletes a specific company by its ID.

  **Response:**
  ```json
  {
    "message": "Company deleted successfully."
  }
  ```

### Job Endpoints

- **Create Job:**
  ```http
  POST /api/v1/companies/{companyId}/jobs
  ```
  Creates a new job for a specific company.

  **Request Body:**
  ```json
  {
    "title": "Job Title",
    "description": "Job Description",
    "location": "Job Location",
    "salary": 60000
  }
  ```

  **Response:**
  ```json
  {
    "id": 1,
    "title": "Job Title",
    "description": "Job Description",
    "location": "Job Location",
    "salary": 60000,
    "companyId": 1
  }
  ```

- **Get All Jobs for a Company:**
  ```http
  GET /api/v1/companies/{companyId}/jobs
  ```
  Retrieves a list of all jobs for a specific company.

  **Response:**
  ```json
  [
    {
      "id": 1,
      "title": "Job Title",
      "description": "Job Description",
      "location": "Job Location",
      "salary": 60000,
      "companyId": 1
    },
    ...
  ]
  ```

- **Get Job by ID:**
  ```http
  GET /api/v1/jobs/{jobId}
  ```
  Retrieves the details of a specific job by its ID.

  **Response:**
  ```json
  {
    "id": 1,
    "title": "Job Title",
    "description": "Job Description",
    "location": "Job Location",
    "salary": 60000,
    "companyId": 1
  }
  ```

- **Update Job:**
  ```http
  PUT /api/v1/jobs/{jobId}
  ```
  Updates the details of a specific job by its ID.

  **Request Body:**
  ```json
  {
    "title": "Updated Job Title",
    "description": "Updated Job Description",
    "location": "Updated Job Location",
    "salary": 65000
  }
  ```

  **Response:**
  ```json
  {
    "id": 1,
    "title": "Updated Job Title",
    "description": "Updated Job Description",
    "location": "Updated Job Location",
    "salary": 65000,
    "companyId": 1
  }
  ```

- **Delete Job:**
  ```http
  DELETE /api/v1/jobs/{jobId}
  ```
  Deletes a specific job by its ID.

  **Response:**
  ```json
  {
    "message": "Job deleted successfully."
  }
  ```

### Review Endpoints

- **Create Review:**
  ```http
  POST /api/v1/companies/{companyId}/reviews
  ```
  Creates a new review for a specific company.

  **Request Body:**
  ```json
  {
    "rating": 5,
    "comment": "Great company to work for!"
  }
  ```

  **Response:**
  ```json
  {
    "id": 1,
    "rating": 5,
    "comment": "Great company to work for!",
    "companyId": 1
  }
  ```

- **Get All Reviews for a Company:**
  ```http
  GET /api/v1/companies/{companyId}/reviews
  ```
  Retrieves a list of all reviews for a specific company.

  **Response:**
  ```json
  [
    {
      "id

": 1,
      "rating": 5,
      "comment": "Great company to work for!",
      "companyId": 1
    },
    ...
  ]
  ```

- **Get Review by ID:**
  ```http
  GET /api/v1/reviews/{reviewId}
  ```
  Retrieves the details of a specific review by its ID.

  **Response:**
  ```json
  {
    "id": 1,
    "rating": 5,
    "comment": "Great company to work for!",
    "companyId": 1
  }
  ```

- **Update Review:**
  ```http
  PUT /api/v1/reviews/{reviewId}
  ```
  Updates the details of a specific review by its ID.

  **Request Body:**
  ```json
  {
    "rating": 4,
    "comment": "Good company to work for."
  }
  ```

  **Response:**
  ```json
  {
    "id": 1,
    "rating": 4,
    "comment": "Good company to work for.",
    "companyId": 1
  }
  ```

- **Delete Review:**
  ```http
  DELETE /api/v1/reviews/{reviewId}
  ```
  Deletes a specific review by its ID.

  **Response:**
  ```json
  {
    "message": "Review deleted successfully."
  }
  ```

## Database Schema

The database schema is designed to support the relationships between companies, jobs, and reviews. Below is a simplified version of the schema.

### Companies Table
| Field         | Type    | Description                  |
|---------------|---------|------------------------------|
| id            | INT     | Primary Key                  |
| name          | VARCHAR | Name of the company          |
| address       | VARCHAR | Address of the company       |
| email         | VARCHAR | Contact email of the company |

### Jobs Table
| Field         | Type    | Description                  |
|---------------|---------|------------------------------|
| id            | INT     | Primary Key                  |
| title         | VARCHAR | Title of the job             |
| description   | TEXT    | Description of the job       |
| location      | VARCHAR | Location of the job          |
| salary        | DECIMAL | Salary for the job           |
| company_id    | INT     | Foreign Key to Companies     |

### Reviews Table
| Field         | Type    | Description                  |
|---------------|---------|------------------------------|
| id            | INT     | Primary Key                  |
| rating        | INT     | Rating for the company       |
| comment       | TEXT    | Comment about the company    |
| company_id    | INT     | Foreign Key to Companies     |


## Contributing

Contributions are welcome! If you have suggestions for improvements or new features, please fork the repository and create a pull request with your changes. Make sure to follow the established coding standards and include tests for any new functionality.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.