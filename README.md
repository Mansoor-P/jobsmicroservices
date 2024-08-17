
# Job Companies and Reviews Microservices Architecture

![Java](https://img.shields.io/badge/Java-17-007396?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.2-brightgreen?logo=spring-boot)
![Maven](https://img.shields.io/badge/Maven-3.8.1-C71A36?logo=apache-maven)
![Docker](https://img.shields.io/badge/Docker-20.10.7-blue?logo=docker)
![MySQL](https://img.shields.io/badge/MySQL-8.0.25-4479A1?logo=mysql&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13.4-336791?logo=postgresql&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-3.8.16-FF6600?logo=rabbitmq)
![Zipkin](https://img.shields.io/badge/Zipkin-2.23.2-5C5C5C?logo=zipkin)
![License](https://img.shields.io/badge/License-MIT-blue)

## Overview

This REST API is designed to manage job listings and reviews for various companies, utilizing a microservices architecture. Built with modern development practices, the API ensures scalability, maintainability, and fault tolerance, offering comprehensive endpoints for managing companies, jobs, and associated reviews.

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
- [Deployment](#deployment)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Company Management**: CRUD operations for companies.
- **Job Management**: CRUD operations for jobs within a company.
- **Review Management**: CRUD operations for reviews related to a company.
- **Service Discovery**: Seamless service registration and discovery using Eureka.
- **Load Balancing**: Intelligent routing and load balancing with Spring Cloud.
- **Fault Tolerance**: Resilient microservices with retry mechanisms and circuit breakers.
- **Distributed Tracing**: Integrated Zipkin for monitoring and tracing.

## Technologies Used

- **Java 17**: Primary programming language.
- **Spring Boot**: Framework for building robust and scalable REST APIs.
- **Spring Cloud Netflix Eureka**: Service registry and discovery.
- **Spring Cloud Gateway**: API Gateway for routing and filtering requests.
- **RabbitMQ**: Message broker for asynchronous communication.
- **MySQL/PostgreSQL**: Relational database management.
- **H2 Database**: In-memory database for development and testing.
- **JPA/Hibernate**: ORM for database interactions.
- **Maven**: Dependency management and build automation.
- **Lombok**: Simplifies Java code by reducing boilerplate.
- **Docker**: Containerization for consistent environments.
- **Zipkin**: Distributed tracing for monitoring microservices.

## Architecture

The system is composed of independent microservices, each responsible for a specific domain:

- **Company Service**: Handles company-related operations, including company details and job associations.
- **Job Service**: Manages job listings, including job creation, updates, and associations with companies.
- **Review Service**: Manages user reviews of companies, integrating with job data.
- **Service Registry**: Manages dynamic service registration and discovery using Eureka.
- **API Gateway**: Routes external requests to the appropriate microservice, handling load balancing and security.
- **RabbitMQ**: Enables asynchronous communication between services, enhancing scalability and resilience.

## Getting Started

### Prerequisites

- Java 17
- Maven
- MySQL or PostgreSQL (for persistent storage)
- Docker (optional, for containerized deployments)

### Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/Mansoor-P/jobsmicroservices.git
   cd jobsmicroservices
   ```

2. **Configure the databases:**
   Update the `application.properties` or `application.yml` files in each service with your database credentials.

3. **Build and package each service:**
   ```sh
   mvn clean install
   ```

4. **Start the Service Registry:**
   ```sh
   cd service-registry
   mvn spring-boot:run
   ```

5. **Start the microservices:**
   ```sh
   cd ../company-service
   mvn spring-boot:run

   cd ../job-service
   mvn spring-boot:run

   cd ../review-service
   mvn spring-boot:run
   ```

6. **Run API Gateway and other services as needed.**

## Deployment

To deploy the microservices architecture, Docker can be used for containerization. Alternatively, you can deploy each service to your cloud provider of choice (e.g., AWS, Azure, GCP).

- **Docker Compose**: Consider using Docker Compose for local deployment. Define services, networks, and volumes to manage the entire stack.

## API Endpoints

### Company Endpoints

- `GET /companies`: Retrieve all companies.
- `POST /companies`: Create a new company.
- `GET /companies/{id}`: Retrieve details of a specific company.
- `PUT /companies/{id}`: Update a company's details.
- `DELETE /companies/{id}`: Delete a company.

### Job Endpoints

- `GET /jobs`: Retrieve all job listings.
- `POST /jobs`: Create a new job listing.
- `GET /jobs/{id}`: Retrieve details of a specific job.
- `PUT /jobs/{id}`: Update a job listing.
- `DELETE /jobs/{id}`: Delete a job listing.

### Review Endpoints

- `GET /reviews`: Retrieve all reviews.
- `POST /reviews`: Create a new review.
- `GET /reviews/{id}`: Retrieve details of a specific review.
- `PUT /reviews/{id}`: Update a review.
- `DELETE /reviews/{id}`: Delete a review.

## Contributing

We welcome contributions! Please follow these guidelines:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/new-feature`).
3. Commit your changes with descriptive messages (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Submit a Pull Request, and our team will review your contribution.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
