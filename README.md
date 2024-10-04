### Sahha API Integration

---

#### Overview
This project is a Spring Boot application that integrates with the Sahha API to retrieve user biomarkers and other information from their devices. The application communicates with the Sahha API using OAuth to authenticate and access users' data. It fetches biomarker data for users based on their external IDs.

---

### Prerequisites

- Java 17
- Maven > 3.6.3+
- Docker (if running via Docker)

---

### Configuration
- Run the following commands to download the source code
```bash
git clone https://github.com/sahha-app/sahha-api.git

cd sahha-api
```

The following environment variables need to be provided for the application to run:

- `clientId`: Your client ID for the Sahha API.
- `clientSecret`: Your client secret for the Sahha API.

A `.env` file is provided in the project directory, however if the file is not found, make sure to create a `.env` file with this exact same syntax

The `.env` file should be created in the root directory (if not provided) of the project and set the values for `clientId` and `clientSecret`:

```env
clientId=YOUR_CLIENT_ID
clientSecret=YOUR_CLIENT_SECRET
```
** `clientId` and `clientSecret` are obtained from Sahha API from [Sahha app](https://app.sahha.ai/dashboard/credentials)



---

### Running the Application
You can run the application using one of the following methods:

#### 1. **Running with Docker (recommended)**

- Build and run the Docker image in one command using the provided script:

```bash
./build.sh
```

This script does the following:
- Reads the `.env` file and exports the variables for the application to use.
- Builds the Maven project and packages it into a JAR file.
- Builds a Docker image using the Dockerfile.
- Runs the Docker container with the application on port `8081`.

**Note:** You need to have Docker installed and configured.

#### 2. **Running Locally with Maven**

If you prefer to run the application directly without Docker, follow these steps:

1. **Install dependencies and build the JAR**:

   Run the following command to install dependencies and package the application:
   ```bash
   mvn clean install -DskipTests
   ```

2. **Set environment variables**:

   You can set the environment variables locally before running the application. For example, in a Unix-based terminal, run:
   ```bash
   export clientId=YOUR_CLIENT_ID
   export clientSecret=YOUR_CLIENT_SECRET
   ```

3. **Run the application**:

   After setting the environment variables, start the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

   The application will be accessible at `http://localhost:8080`.

This README looks solid! Here's a suggested fix for your alternative way of running the application via the JAR file:



#### 3. **Running the JAR file directly**

After setting up your environment variables, you can run the application from the built JAR file. First, make sure to build the project:

1. Build the project and generate the JAR:
   ```bash
   mvn clean package -DskipTests
   ```

2. Run the JAR with the necessary environment variables:
   ```bash
   java -jar target/app-v1.jar
   ```

   The application will be accessible at `http://localhost:8080`.

---

This completes the alternative method for running the app. The rest of the README structure looks great. Let me know if you'd like further tweaks!

---

### API Endpoints

#### 1. **Biomarkers**
- **Endpoint**: `/public/api/v1/biomarkers/get/{externalId}`
- **Method**: `GET`
- **Description**: Retrieves biomarker data for a user based on their external ID.
- **Parameters**:
    - `externalId`: The ID of the user in the external system.
    - `biomarker` (optional): The type of biomarker to filter the results.

Example request:
```bash
curl "http://localhost:8080/public/api/v1/biomarkers/get/{externalId}?biomarker=sleep"
```
** List of all biomarker variables can be found in the [Sahha Biomarkers](https://docs.sahha.ai/docs/products/biomarkers#list-of-biomarkers)

---

### Project Structure

- **Configuration**:
    - `AccountToken`: Handles setting and retrieving the account token in runtime.

- **Controllers**:
    - `BiomarkersController`: Exposes an endpoint to retrieve biomarker data using the user's external ID.

- **Services**:
    - `AccountService`: Fetches the account token from Sahha API.
    - `BiomarkerService`: Retrieves biomarker data from Sahha API.

---

### Dockerfile Overview

The Dockerfile is configured to use a base image of Java 17 (Alpine). When the Docker container runs, it:
- Copies the Spring Boot JAR file to the container.
- Exposes port `8080` for the application.
- Executes the JAR file to start the application.

---

### License
This project is licensed under the MIT License.
