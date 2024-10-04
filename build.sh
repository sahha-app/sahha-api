#!/bin/bash

export $(cat .env | xargs)


# Run Maven build to create the JAR file
echo "Running Maven build..."
mvn package


# Build the Docker image with the provided clientId and clientSecret
echo "Building Docker image..."
docker build -t sahha-app .

echo "Docker image built successfully!"

echo "Running Docker image..."
docker run -p 8081:8080 --env-file .env -d sahha-app


