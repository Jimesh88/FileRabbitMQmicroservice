This project contains two microservices:
1.	File Service: Reads the contents of a file and sends the data to RabbitMQ.
2.	API Service: Retrieves the data stored in a PostgreSQL database using pagination, filtering, and search.
3.	Consumer service: Reads file content from rabbitmq and stores it in database.
________________________________________
Project Structure
•	File Service: Reads a file line by line and pushes data to RabbitMQ.
•	API Service: Fetches stored data from PostgreSQL, with pagination, filtering, and search capabilities.
•	RabbitMQ: Acts as a message broker to queue data between services.
•	PostgreSQL: Stores data processed by the consumer service.
________________________________________
Prerequisites
1.	Java: Ensure you have Java 17
2.	PostgreSQL: A running PostgreSQL instance.
3.	RabbitMQ: A running RabbitMQ instance.
4.	Spring Boot: Framework used to create the microservices.
5.	Docker.
________________________________________
Installation
Step 1: Clone the Repository
git clone https://github.com/Jimesh88/FileRabbitMQmicroservice.git
cd <project-directory>
Step 2: Setup RabbitMQ and PostgreSQL using Docker
A docker-compose.yml file has been provided to quickly set up RabbitMQ and PostgreSQL. To start the services, run:
docker-compose up
•	RabbitMQ will be available at localhost:5672 and its management console at localhost:15672.
•	PostgreSQL will be available at localhost:5432.
Step 3: Configure Database Connection
Database configuration for Consumer service
spring.application.name=consumer-service
# Database connection
# Database connection properties
spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=postgres
spring.datasource.password=testdb

# Optional: Hibernate properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

server.port=8081
Database configuration for api service
spring.application.name=api-service

spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=postgres
spring.datasource.password=testdb
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8082

________________________________________
Usage
1. File Service
The File Service reads a file from the specified path, line by line, and pushes each line into a RabbitMQ queue.
API Endpoint
•	Endpoint: /read-file
•	Method: GET
•	Query Parameter: path (the full file path of the file you want to read)
Example request:
GET http://localhost:8082/read-file?path=/path/to/your/file.txt
This will read the file and send each line to RabbitMQ under the queue named fileQueue.
________________________________________
2. API Service
The API Service provides an endpoint to retrieve data stored in PostgreSQL, with features such as pagination, filtering by name, and searching.
API Endpoint
•	Endpoint: /records
•	Method: GET
•	Query Parameters:
o	pageno: Page number (default is 0).
o	pagesize: Number of records per page (default is 10).
o	name: (Optional) Filter based on the name field.
Example request:
GET http://localhost:8081/records?pageno=0&pagesize=10&name=xyz
This will fetch the first 10 records where the name contains 'xyz', paginated.
________________________________________
________________________________________
Running the Services
After setting up PostgreSQL and RabbitMQ, you can start each service separately.
1.	Start the File Service:
2.	Start Consumer service
3.	Start the API Service:
  The services will be available at:
•	File Service: http://localhost:8080
•	API Service: http://localhost:8082
•	Consumer service: http://localhost:8081
________________________________________

