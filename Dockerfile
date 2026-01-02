
# Start from a base image with a Java runtime
FROM openjdk:17.0.2-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/*.jar rbs-avail-api.jar

# Expose the port your Spring Boot app runs on (default is 8080)
EXPOSE 8081

# Command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "rbs-avail-api.jar"]