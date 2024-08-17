# Use the official OpenJDK 17 image as a base
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Adjust the path if the jar file is in a different location
COPY target/jobcompanyreview-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your application will run on
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
