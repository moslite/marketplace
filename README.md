# Marketplace

This is a RESTful API developed with Spring Boot that allows managing orders in a marketplace management system.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [API Documentation](#api-documentation)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact) 

## Features

- List orders
- Create new order
- Update existing order
- Delete orders

## Prerequisites

- **Java 21** or higher
- **Maven** 3.13.0 or higher
- **Database** AWS DynamoDB

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/moslite/marketplace.git
   ```
2. Navigate to the application directory:
    ```bash
   cd repository-name
   ```
3. Build the project:
    ```bash
   mvn clean install
   ```

## Configuration

Configure the application.yml file with your database information and other necessary settings:
   
```
aws.accessKeyId=your_access_key_id
aws.secretKey=your_secrect_key
aws.region=your_region
aws.endpoint=your_endpoint
```   

## Running the Application

To run the application, use Maven:
```bash
mvn spring-boot:run
```

Or, if you prefer, generate a JAR file and run it:
```bash
mvn clean package
java -jar target/marketplace.jar
```

# Using Docker Compose

This application includes a docker-compose.yml file for easy setup and deployment using Docker Compose. To start the application with Docker Compose, follow these steps:

1. Make sure Docker and Docker Compose are installed on your machine.
2. In the project directory, run the following command to build and start the containers:
```bash
docker-compose up --build
```
3. The application will be accessible at http://localhost:8090.

To stop and remove the containers, use:
```bash
docker-compose down
```

# Testing

To run the tests, use the command:
```bash
mvn test
```

# API Documentation

API documentation can be accessed via Swagger after running the application:
```bash
http://localhost:8090/swagger-ui.html
```

# Technologies Used

- Spring Boot - Main framework
- Spring Data JPA - For database interactions
- Spring Security - For authentication and authorization
- OpenAPI Specification - For API documentation
- Docker and Docker Compose - For containerization and orchestration
- Database - DynamoDB
- Maven - Dependency management

# Contributing

Contributions are welcome! Follow the steps below:

1. Fork the project
2. Create a branch for your feature (git checkout -b feature/MyFeature)
3. Commit your changes (git commit -m 'Adding my feature')
4. Push to the branch (git push origin feature/MyFeature)
5. Open a Pull Request

# License

This project is licensed under the MIT License - see the LICENSE file for details.

# Contact
Murilo Souza - moslite@hotmail.com

Project Link: https://github.com/moslite/marketplace
