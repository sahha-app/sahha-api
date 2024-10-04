#!/bin/bash

export $(cat .env | xargs)

echo $clientId
echo $clientSecret


# Run Maven build to create the JAR file
echo "Running Maven build..."
mvn clean package


# Build the Docker image with the provided clientId and clientSecret
echo "Building Docker image..."
docker build -t sahha-app .

echo "Docker image built successfully!"

echo "Running Docker image..."
docker run --env-file .env -d sahha-app -p 8081:8080


# Display a success message