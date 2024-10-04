# Use a base image with JDK
FROM openjdk:17-jdk-alpine


# Set working directory
WORKDIR /app

# Copy your Spring Boot JAR file to the container
COPY /target/app-v1.jar /app/app-v1.jar

# Expose the port your Spring Boot app runs on (typically 8080)
EXPOSE 8080

# Command to run your Spring Boot application, passing variables as JVM arguments
ENTRYPOINT ["java", "-jar", "/app/app-v1.jar"]