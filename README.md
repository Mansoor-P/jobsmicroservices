
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

This **Microservices-based REST API**, built with **Java 17** and **Spring Boot**, manages job listings, companies, and reviews for various companies. Each service is independently developed, ensuring **scalability**, **maintainability**, and **fault tolerance**. The API offers **CRUD operations** and uses a **microservices architecture** for efficient handling of resources. Integrated with tools like **Spring Cloud**, **RabbitMQ**, and **Zipkin**, the system supports **service discovery**, **asynchronous communication**, and **distributed tracing**.

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
- **Service Discovery**: Seamless service registration and discovery using [Eureka](https://spring.io/projects/spring-cloud).
- **Load Balancing**: Intelligent routing and load balancing with [Spring Cloud](https://spring.io/projects/spring-cloud).
- **Fault Tolerance**: Resilient microservices with retry mechanisms and circuit breakers.
- **Distributed Tracing**: Integrated [Zipkin](https://zipkin.io/) for monitoring and tracing.

## Technologies Used

- **[Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)**: Primary programming language.
- **[Spring Boot](https://spring.io/projects/spring-boot)**: Framework for building robust and scalable REST APIs.
- **[Spring Cloud Netflix Eureka](https://spring.io/projects/spring-cloud-netflix)**: Service registry and discovery.
- **[Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)**: API Gateway for routing and filtering requests.
- **[RabbitMQ](https://www.rabbitmq.com/)**: Message broker for asynchronous communication.
- **[MySQL](https://www.mysql.com/)** or **[PostgreSQL](https://www.postgresql.org/)**: Relational database management.
- **[H2 Database](https://www.h2database.com/)**: In-memory database for development and testing.
- **[JPA/Hibernate](https://hibernate.org/)**: ORM for database interactions.
- **[Maven](https://maven.apache.org/)**: Dependency management and build automation.
- **[Lombok](https://projectlombok.org/)**: Simplifies Java code by reducing boilerplate.
- **[Docker](https://www.docker.com/)**: Containerization for consistent environments.
- **[Zipkin](https://zipkin.io/)**: Distributed tracing for monitoring microservices.

## Architecture

The system is composed of independent microservices, each responsible for a specific domain:

- **Company Service**: Handles company-related operations, including company details and job associations.
- **Job Service**: Manages job listings, including job creation, updates, and associations with companies.
- **Review Service**: Manages user reviews of companies, integrating with job data.
- **Service Registry**: Manages dynamic service registration and discovery using [Eureka](https://spring.io/projects/spring-cloud).
- **API Gateway**: Routes external requests to the appropriate microservice, handling load balancing and security.
- **RabbitMQ**: Enables asynchronous communication between services, enhancing scalability and resilience.

## Getting Started

### Prerequisites

- **Java 17**: Download from [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
- **Maven**: Download from [Apache Maven](https://maven.apache.org/download.cgi).
- **MySQL or PostgreSQL**: Install [MySQL](https://dev.mysql.com/downloads/) or [PostgreSQL](https://www.postgresql.org/download/).
- **Docker (optional)**: Download from [Docker](https://www.docker.com/products/docker-desktop).

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Mansoor-P/jobsmicroservices.git
   cd jobsmicroservices
   ```

2. **Configure the databases**:
   Update the `application.properties` or `application.yml` files in each service with your database credentials.

3. **Build and package each service**:
   ```bash
   mvn clean install
   ```

4. **Start the Service Registry**:
   ```bash
   cd service-registry
   mvn spring-boot:run
   ```

5. **Start the microservices**:
   ```bash
   cd ../company-service
   mvn spring-boot:run

   cd ../job-service
   mvn spring-boot:run

   cd ../review-service
   mvn spring-boot:run
   ```

6. **Run API Gateway and other services as needed.**

## Deployment

To deploy the microservices architecture, Docker can be used for containerization. Alternatively, you can deploy each service to your cloud provider of choice (e.g., [AWS](https://aws.amazon.com/), [Azure](https://azure.microsoft.com/en-us/), [GCP](https://cloud.google.com/)).

- **Docker Compose**: Consider using [Docker Compose](https://docs.docker.com/compose/) for local deployment. Define services, networks, and volumes to manage the entire stack.

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

This project is licensed under the [MIT License](LICENSE) - see the [LICENSE](LICENSE) file for details.
