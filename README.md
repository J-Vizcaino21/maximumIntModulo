# Maximum Integer Modulo

This software is designed to evaluate three numerical parameters: X, Y, and N. In this context, X represents the modulo, Y denotes the remainder, and N signifies the maximum allowable integer.

The project is developed using Maven with Java 11 and Spring Boot 2.7.

### Getting Started:
To utilize the software, follow these steps:

1. **Clone the Project Repository:**
git clone [project_repository_url]

2. **Install the Source Code:**
mvn install 

3. **Run the Application:**
mvn spring-boot:run


Ensure that you have Maven and Java 11 installed on your system before proceeding.


## Endpoints:

- **/setParameters**:
- Description: This endpoint allows setting the parameters X, Y, and N for calculating the maximum integer modulo.
- Method: POST
- Input Parameters: JSON with values of X, Y, and N
- Example Usage: `POST /setparameters { "X": 7, "Y": 5, "N": 12345 }`

- **/getMaximumInteger**:
- Description: This endpoint allows get the proper calculation for the given X, Y, and N .
- Method: GET
- Output Parameters: JSON with the maximum possible integer
- Example Usage: `GET /getMaximumInteger`


### The frontend must be cloned using the following link:
https://github.com/J-Vizcaino21/maximumIntFront




