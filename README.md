# Job Companies and Reviews REST API

## Overview
This REST API is designed to manage job listings and reviews for various companies. It follows a monolithic architecture and is built using modern development practices to ensure scalability and maintainability. The API provides endpoints for managing companies, jobs, and reviews associated with those companies.

## Features
- **Company Management**: Create, read, update, and delete companies.
- **Job Management**: Create, read, update, and delete jobs for a company.
- **Review Management**: Create, read, update, and delete reviews for a company.

## Technologies Used
- **Java**: The primary programming language.
- **Spring Boot**: For building the REST API.
- **H2-Database**: For Testing Purpose
- **MySQL/PostgreSQL**: For the relational database.
- **JPA/Hibernate**: For ORM (Object-Relational Mapping).
- **Maven**: For project management and dependency management.
- **Lombok**: To reduce boilerplate code.

## Getting Started

### Prerequisites
- Java 17 or later
- Maven 
- H2-Database or MySQL or PostgreSQL database

### Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/Mansoor-P/jobsmicroservices.git
   cd jobsmicroservices
   ```

2. **Configure the database:**
    - Update the `application.properties` file in the `src/main/resources` directory with your database credentials.
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build the project:**
   ```sh
   mvn clean install
   ```

4. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints

### Company Endpoints
- **Create Company:**
  ```http
  POST /api/v1/companies
  ```
  Creates a new company.

- **Get All Companies:**
  ```http
  GET /api/v1/companies
  ```
  Retrieves a list of all companies.

- **Get Company by ID:**
  ```http
  GET /api/v1/companies/{companyId}
  ```
  Retrieves the details of a specific company by its ID.

- **Update Company:**
  ```http
  PUT /api/v1/companies/{companyId}
  ```
  Updates the details of a specific company by its ID.

- **Delete Company:**
  ```http
  DELETE /api/v1/companies/{companyId}
  ```
  Deletes a specific company by its ID.

### Job Endpoints
- **Create Job:**
  ```http
  POST /api/v1/companies/{companyId}/jobs
  ```
  Creates a new job for a specific company.

- **Get All Jobs for a Company:**
  ```http
  GET /api/v1/companies/{companyId}/jobs
  ```
  Retrieves a list of all jobs for a specific company.

- **Get Job by ID:**
  ```http
  GET /api/v1/jobs/{jobId}
  ```
  Retrieves the details of a specific job by its ID.

- **Update Job:**
  ```http
  PUT /api/v1/jobs/{jobId}
  ```
  Updates the details of a specific job by its ID.

- **Delete Job:**
  ```http
  DELETE /api/v1/jobs/{jobId}
  ```
  Deletes a specific job by its ID.

### Review Endpoints
- **Create Review:**
  ```http
  POST /api/v1/companies/{companyId}/reviews
  ```
  Creates a new review for a specific company.

- **Get All Reviews for a Company:**
  ```http
  GET /api/v1/companies/{companyId}/reviews
  ```
  Retrieves a list of all reviews for a specific company.

- **Get Review by ID:**
  ```http
  GET /api/v1/reviews/{reviewId}
  ```
  Retrieves the details of a specific review by its ID.

- **Update Review:**
  ```http
  PUT /api/v1/reviews/{reviewId}
  ```
  Updates the details of a specific review by its ID.

- **Delete Review:**
  ```http
  DELETE /api/v1/reviews/{reviewId}
  ```
  Deletes a specific review by its ID.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.
