# Airline System

This is a Spring Boot application I developed to manage airlines and their associated planes. It includes RESTful Web Services for API interactions, JWT authentication to secure the endpoints, and PostgreSQL for database management.

## Project Structure

The project structure is pretty straightforward:

- **`src/main/java`**: This is where all the Java source code lives, including controllers, services, repositories, and entities.
- 
- **`src/main/resources`**: Contains the application properties and other resource files like templates and static content.
- 
- **`src/test/java`**: Holds the unit and integration tests to ensure everything works as expected.

## Prerequisites

Before you start, make sure you have the following installed:

- **Java 17**: The application is built with Java 17.
- 
- **Gradle**: We’re using Gradle as the build tool.(8 or higher)
- 
- **PostgreSQL**: The application connects to a PostgreSQL database.

## Getting Started

To get the project up and running, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/airline-system.git
   cd airline-system
   
2. **Set up PostgreSQL:**

    Create a PostgreSQL database and then update the connection details in src/main/resources/application.properties:
   
   -spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
   
   -spring.datasource.username=your-username
   
   -spring.datasource.password=your-password

4. **Builld the project:**

   Once everything is set up, you can build the project with:
   - ./gradlew build
     
5. **Run the Application:**
   
   - ./gradlew bootRun
     
6. **Access the Application:**
 
   - The application will be running at http://localhost:8080.
     
## Dependencies

 - Here’s a quick rundown of the key dependencies:

## Spring Boot Starters:

 -spring-boot-starter-data-jpa: For database interactions using JPA.
 
 -spring-boot-starter-security: For securing the application.
 
 -spring-boot-starter-validation: For validating incoming requests.
 
 -spring-boot-starter-web: To build the RESTful web services.
 
 -spring-boot-starter-oauth2-client and spring-boot-starter-oauth2-resource-server: For OAuth2 and resource server capabilities.

## JWT Handling:

   -io.jsonwebtoken:jjwt-api:0.12.3, io.jsonwebtoken:jjwt-impl:0.12.3, io.jsonwebtoken:jjwt-jackson:0.12.3: For managing JWT authentication.

## MapStruct:

  -org.mapstruct:mapstruct:1.6.0.Beta1, org.mapstruct:mapstruct-processor:1.6.0.Beta1: For object mapping.

## Lombok:

  -org.projectlombok:lombok: To reduce boilerplate code with annotations.

## PostgreSQL Driver:

  -org.postgresql:postgresql: For connecting to the PostgreSQL database.
  
# Postman Collection

I have also included a Postman Collection to help you quickly test the API endpoints. The collection covers the following operations:

## Importing the Collection

To import the collection into Postman:

  -Open Postman.
  
  -Click on Import in the top left corner.
  
  -Select the Postman Collection JSON file.
  
  -Set up the environment variables.

## To set up environment variables in Postman:

-Open Postman and click on the Environments dropdown in the left select list.

-Select Environments.

-Click Add to create a new environment.

-Name your environment (e.g., "Airline API").

-Add the variable-> 

    Variable : url
    
    Type: default
    
    Initial value: http://localhost:8080
    
    Current value: http://localhost:8080
  
  
# Airline REST API Documentation

## Overview

This document provides detailed information about the Airline REST API, including endpoints for managing airlines and aircraft, and how to interact with the API using Postman.

## API Endpoints

### Obtain Authentication Token

- **Method:** POST
- **Endpoint:** `/api-token-auth/`
- **Body:**
  ```json
  {
    "username": "user",
    "password": "1234"
  }

  

## Obtain Authentication Token: Retrieves a JWT token for authentication.

-Method: POST

-Endpoint: http://localhost:8080/api-token-auth/

-Body: JSON object with username and password.

-Tests: Confirms a 200 status code and extracts the token from the response.

## Create an Airline: Creates a new airline record.

-Method: POST

-Endpoint: http://localhost:8080/airline/

-Body: JSON object with airline details like name, callsign, founded_year, and base_airport.

-Tests: Verifies successful creation and extracts the airline ID and name.

## Update an Airline: Updates an existing airline's information.

-Method: PATCH

-Endpoint: http://localhost:8080/airline/{{airline_id}}

-Body: JSON object with the fields to update, such as founded_year.

-Tests: Confirms a 200 status code and verifies the updated information.

## Retrieve an Airline: Retrieves details of a specific airline.

-Method: GET

-Endpoint: http://localhost:8080/airline/{{airline_id}}

-Tests: Confirms a 200 status code and verifies the retrieved airline's name and associated aircraft.

## List All Airlines: Lists all airlines in the system.

-Method: GET

-Endpoint:http://localhost:8080/airline/

-Tests: Confirms a 200 status code.

## Create an Aircraft: Adds a new aircraft to an airline.

-Method: POST

-Endpoint: http://localhost:8080/aircraft/

-Body: JSON object with aircraft details like manufacturer_serial_number, type, model, operator_airline, and number_of_engines.

-Tests: Verifies successful creation and extracts the aircraft ID.

## Update an Aircraft: Updates information of an existing aircraft.

-Method: PATCH

-Endpoint: http://localhost:8080/airline/{{airline_id}} 

-Body: JSON object with fields to update, such as manufacturer_serial_number.

-Tests: Confirms a 200 status code and verifies the updated information.

## Retrieve an Aircraft: Retrieves details of a specific aircraft.

-Method: GET

-Endpoint: http://localhost:8080/aircraft/{{aircraft_id}}

-Tests: Confirms a 200 status code and verifies the retrieved aircraft's details.

## Delete an Aircraft: Deletes a specific aircraft.

-Method: DELETE

-Endpoint: http://localhost:8080/airline/{{aircraft_id}}

-Tests: Confirms a 204 status code for successful deletion.

## Delete an Airline: Deletes a specific airline.

-Method: DELETE

-Endpoint: http://localhost:8080/airline/{{airline_id}}

-Tests: Confirms a 204 status code for successful deletion.

## Environment Variables

To make it easier to work with different environments, the Postman collection uses the following environment variables:

{{url}}: The base URL of the API.

{{token}}: The JWT token used for authentication.

{{airline_id}}: The ID of the airline.

{{aircraft_id}}: The ID of the aircraft.


# Important Note

## Issue with Endpoints:

For the "Update an Aircraft" and "Delete an Aircraft" operations, there is an error in the provided endpoints. The correct endpoints should be:

Update an Aircraft: /aircraft/{{aircraft_id}}

Delete an Aircraft: /aircraft/{{aircraft_id}}

Please ensure to use these corrected endpoints to perform the respective operations.

  
