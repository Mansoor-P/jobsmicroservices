
## Docker Setup for Job Companies and Reviews REST API

### Docker Compose File

The Docker Compose file is used to define and run multi-container Docker applications. In this setup, we are using Docker Compose to manage a PostgreSQL database and a pgAdmin instance for database management.

#### Version

We are using version '3.8' of the Docker Compose file format.

#### Services

1. **PostgreSQL Service**
- **Service Name**: `postgres`
- **Image**: Uses the official `postgres` Docker image.
- **Container Name**: `postgres_container`
- **Environment Variables**:
    - `POSTGRES_USER`: Sets the PostgreSQL username to `your_userName`.
    - `POSTGRES_PASSWORD`: Sets the PostgreSQL password to `your_password`.
    - `PGDATA`: Specifies the directory where PostgreSQL will store data.
- **Volumes**:
    - `postgres:/data/postgres`: Mounts a volume to persist PostgreSQL data.
- **Ports**:
    - `5432:5432`: Maps port 5432 on the host to port 5432 on the container.
- **Networks**:
    - `postgres`: Attaches the container to the `postgres` network.
- **Restart Policy**:
    - `unless-stopped`: Ensures the container restarts unless it is explicitly stopped.

2. **pgAdmin Service**
- **Service Name**: `pgadmin`
- **Image**: Uses the official `dpage/pgadmin4` Docker image.
- **Container Name**: `pgadmin_container`
- **Environment Variables**:
    - `PGADMIN_DEFAULT_EMAIL`: Sets the default email for pgAdmin login to `pgadmin4@pgadmin.org`.
    - `PGADMIN_DEFAULT_PASSWORD`: Sets the default password for pgAdmin login to `admin`.
    - `PGADMIN_CONFIG_SERVER_MODE`: Runs pgAdmin in server mode (`False` to disable).
- **Volumes**:
    - `pgadmin:/var/lib/pgadmin`: Mounts a volume to persist pgAdmin data.
- **Ports**:
    - `5050:80`: Maps port 5050 on the host to port 80 on the container.
- **Networks**:
    - `postgres`: Attaches the container to the `postgres` network.
- **Restart Policy**:
    - `unless-stopped`: Ensures the container restarts unless it is explicitly stopped.

#### Networks

- **postgres**: Defines a custom network named `postgres` for inter-container communication.

#### Volumes

- **postgres**: Defines a volume for persisting PostgreSQL data.
- **pgadmin**: Defines a volume for persisting pgAdmin data.

### Docker Compose File

```yaml
version: '3.8'

services:
  postgres:
    image: postgres
    container_name: postgres_container
    environment:
      POSTGRES_USER: you_userName
      POSTGRES_PASSWORD: password
      PGDATA: /data/postgres
    volumes:
      - postgres:/data/postgres
    ports:
      - "5432:5432"
    networks:
      - postgres
    restart: unless-stopped

  pgadmin:
    image: dpage/pgadmin4
    container_name: pgadmin_container
    environment:
      PGADMIN_DEFAULT_EMAIL: pgadmin4@pgadmin.org
      PGADMIN_DEFAULT_PASSWORD: admin
      PGADMIN_CONFIG_SERVER_MODE: 'False'
    volumes:
      - pgadmin:/var/lib/pgadmin
    ports:
      - "5050:80"
    networks:
      - postgres
    restart: unless-stopped

networks:
  postgres:

volumes:
  postgres:
  pgadmin:
```

### Dockerfile

The Dockerfile is used to build a Docker image for your Java application. This file defines the steps needed to set up the environment and run your application inside a Docker container.

#### Steps

1. **Base Image**
- `FROM openjdk:22-jdk`: Uses the official OpenJDK 22 image as the base image.

2. **Working Directory**
- `WORKDIR /app`: Sets the working directory inside the container to `/app`.

3. **Copy JAR File**
- `COPY target/*.jar app.jar`: Copies the JAR file from the local `target` directory to the container's `/app` directory, renaming it to `app.jar`.

4. **Expose Port**
- `EXPOSE 8080`: Exposes port 8080 to allow traffic to the application running inside the container.

5. **Run Application**
- `CMD ["java", "-jar", "app.jar"]`: Specifies the command to run the JAR file using the `java -jar` command.

### Dockerfile

```dockerfile
# Use the official OpenJDK 22 image as a base
FROM openjdk:22-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from your local target directory to the container
COPY target/*.jar app.jar

# Expose the port that your application will run on
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
```

### Running the Application

To run your application using Docker Compose, follow these steps:

1. **Build the Docker Image**
   ```sh
   docker build -t jobmicroservices .
   ```

2. **Start the Docker Containers**
   ```sh
   docker-compose up -d
   ```

This setup will start the PostgreSQL database, pgAdmin for database management, and your Java application, making it easy to manage and deploy your services. The PostgreSQL database will be available on port 5432, pgAdmin will be accessible on port 5050, and your Java application will run on port 8080.


