Here's a README file for your Spring Boot application that integrates with Sahha API. It includes both Docker and manual run instructions, setup details, and an overview of the project.

---

# Sahha API Integration Application

This Spring Boot application integrates with the Sahha API to retrieve user biomarkers and account information. It fetches an account token at runtime, which is used globally to authenticate requests to the Sahha API. The application also allows you to retrieve user biomarker data by using an external user ID.

## Prerequisites

- **Java 21** (Ensure `JAVA_HOME` is correctly set)
- **Maven** (for building the Spring Boot application)
- **Docker** (optional, for running the application inside a container)
- **Environment variables**: `CLIENT_ID`, `CLIENT_SECRET`

## Configuration

Before running the application, make sure to provide the required environment variables:

- `CLIENT_ID`: The client ID for accessing the Sahha API
- `CLIENT_SECRET`: The client secret for accessing the Sahha API

You can set these variables in an `.env` file or export them manually:

```
# .env file
CLIENT_ID=your_client_id_here
CLIENT_SECRET=your_client_secret_here
```

## Project Structure

- **AccountToken Configuration**: Manages the account token globally across the application.
- **AccountController**: Provides an API to retrieve the account token from Sahha.
- **BiomarkersController**: Allows fetching of biomarker data based on an external user ID and optional biomarker types.
- **Service Layer**: The `AccountService` and `BiomarkerService` classes handle API calls to Sahha for fetching the account token and biomarker data, respectively.

## How to Run

### Running Without Docker

1. **Clone the repository** and navigate to the project directory.

   ```bash
   git clone <repository_url>
   cd sahha-api-app
   ```

2. **Set environment variables**.

   You can set the environment variables by creating an `.env` file in the project root:

   ```
   CLIENT_ID=your_client_id_here
   CLIENT_SECRET=your_client_secret_here
   ```

   Then, run:

   ```bash
   export $(cat .env | xargs)
   ```

3. **Run the application**.

   First, package the Spring Boot application:

   ```bash
   mvn clean package
   ```

   Run the Spring Boot application:

   ```bash
   java -jar target/app-v1.jar
   ```

   The application will run on port **8080** by default.

4. **Access the API**.

    - Retrieve the account token:  
      `GET /public/api/v1/account/get`

    - Get biomarkers for a user:  
      `GET /public/api/v1/biomarkers/get/{externalId}?biomarker={biomarker}`

### Running with Docker

1. **Set environment variables**.

   Ensure you have an `.env` file with the necessary environment variables:

   ```
   CLIENT_ID=your_client_id_here
   CLIENT_SECRET=your_client_secret_here
   ```

2. **Build and run the application using Docker**.

   Use the provided `build.sh` script or run the commands manually.

   **Script to Build and Run Docker Container**:
   ```bash
   #!/bin/bash

   # Export environment variables from .env
   export $(cat .env | xargs)

   # Run Maven build to create the JAR file
   echo "Running Maven build..."
   mvn clean package

   # Build the Docker image
   echo "Building Docker image..."
   docker build -t sahha-app .

   # Run the Docker container
   echo "Running Docker image..."
   docker run -p 8081:8080 --env-file .env -d sahha-app

   echo "Docker container is running on port 8081."
   ```

3. **Build the Docker image** manually if not using the script.

   ```bash
   mvn clean package
   docker build -t sahha-app .
   ```

4. **Run the Docker container**.

   ```bash
   docker run -p 8081:8080 --env-file .env -d sahha-app
   ```

   The application will be accessible at `http://localhost:8081`.

## API Endpoints

- **Retrieve Account Token**:  
  `GET /public/api/v1/account/get`  
  Fetches the account token from the Sahha API.

- **Get Biomarkers for a User**:  
  `GET /public/api/v1/biomarkers/get/{externalId}?biomarker={biomarker}`  
  Retrieves biomarker data for the specified user.

## Dockerfile

The Dockerfile for this application uses a minimal image with JDK 17:

```dockerfile
# Use a base image with JDK 17
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the Spring Boot JAR file
COPY /target/app-v1.jar /app/app-v1.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/app-v1.jar"]
```

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

---

This README should cover all necessary steps and information for running and using the Sahha API integration application! Let me know if you need any further customization.
