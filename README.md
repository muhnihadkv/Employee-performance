# Employee-performance

## Overview

This project is a Spring Boot application designed to manage employee performance ratings and distributions. It provides a set of RESTful APIs to initialize default ratings, add employees, manage distributions, and generate a bell curve for performance appraisal.

## Features

- **Initialize Default Ratings**: Set up default ratings for employees.
- **Add Employees**: Add new employees with their respective ratings.
- **Manage Distributions**: Add and flush distributions for performance ratings.
- **Bell Curve Analysis**: Suggest employees whose ratings need revision based on deviations.

## Prerequisites

- **Java Development Kit (JDK)**: Ensure JDK 11 or later is installed.
- **Integrated Development Environment (IDE)**: IntelliJ IDEA or Eclipse recommended.
- **MySQL Database**: Ensure MySQL is installed and running.

## Setup Instructions

### Setting Up the IDE

1. **IntelliJ IDEA**:
   - Install IntelliJ IDEA from [JetBrains](https://www.jetbrains.com/idea/download/).
   - Open IntelliJ IDEA and import the project as a Maven or Gradle project.

2. **Eclipse**:
   - Install Eclipse IDE from [Eclipse Downloads](https://www.eclipse.org/downloads/).
   - Import the project by selecting `File -> Import -> Existing Maven Projects` or `Existing Gradle Project`.

### Configuring MySQL

1. **Create Database**:
   - Open MySQL Workbench or any MySQL client.
   - Create a new database for the application:
     ```sql
     CREATE DATABASE employee_performance;
     ```

2. **Configure `application.properties`**:
   - Open the `src/main/resources/application.properties` file.
   - Configure the MySQL database connection:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/employee_performance
     spring.datasource.username=your_mysql_username
     spring.datasource.password=your_mysql_password
     spring.jpa.hibernate.ddl-auto=update
     ```

### Running the Application

1. **Build the Project**:
   - Use the IDE's build tool to build the project. For Maven, use `mvn clean install`. For Gradle, use `gradle clean build`.

2. **Run the Application**:
   - In your IDE, run the `main` method in the `Application` class, or use the command line:
     ```bash
     mvn spring-boot:run
     ```
   - Or for Gradle:
     ```bash
     gradle bootRun
     ```

### Available APIs

1. **Initialize Ratings**:
   - Endpoint: `POST /initializeRatings`
   - Description: Initializes default ratings in the system.

2. **Add Employee**:
   - Endpoint: `POST /addEmployee`
   - Description: Adds a new employee.
   - Request Body (JSON):
     ```json
     {
       "name": "John Doe",
       "rating": "A"
     }
     ```

3. **Add Distribution**:
   - Endpoint: `POST /addDistribution`
   - Description: Adds a new distribution.
   - Request Body (JSON):
     ```json
     {
       "rating": "A",
       "standard": 20.0
     }
     ```

4. **Flush Distribution**:
   - Endpoint: `DELETE /flushDistribution`
   - Description: Deletes all existing distributions.

5. **Bell Curve Analysis**:
   - Endpoint: `GET /bellCurve`
   - Description: Provides advice or suggestions on which employees' ratings should be revised based on deviations.

## Conclusion

This application provides a comprehensive solution for managing employee performance ratings and distributions. By following the setup instructions, you can easily run the application and utilize the provided APIs to manage and analyze employee performance data.
