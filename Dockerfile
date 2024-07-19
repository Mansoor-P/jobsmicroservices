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
