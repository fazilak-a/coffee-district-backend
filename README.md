# coffee-district-backend
Coffee District is a full-stack e-commerce application for exploring coffee, cookies and brewing equipment, allowing users to browse products and manage a shopping cart. <br>

This independent portfolio project was developed as part of my practical learning journey in full-stack development. 
The repository contains the backend application, developed with Java and Spring Boot. It provides REST APIs for product retrieval and user authentication, with data persistence handled through Spring Data JPA and MySQL. <br>
<br>
The project follows a layered architecture, separating HTTP request handling, business logic, data access and entity modelling. <br>
Additional development materials, testing resources, design assets and documentation can be presented and discussed during the interview process. <br>
<br>
<br>
🔗 Frontend repository: https://github.com/fazilak-a/coffee-district-frontend <br>

<br>

## Technologies <br>
- Java <br>
- Spring Boot <br>
- Spring Data JPA<br>
- Hibernate<br>
- Spring Security<br>
- MySQL<br>
- Maven<br>
- BCrypt password hashing<br>
- REST APIs<br>
- Postman API testing<br>
<br>


## Main Features
<br>

**Product Catalogue**<br>
•	Retrieve products through paginated API endpoints<br>
•	Retrieve products by category<br>
•	Retrieve individual products using their slugs<br>
•	Filter coffee products by country, brand and aroma<br>
•	Filter cookie products by brand and allergens<br>
•	Filter machinery products by country, brand and color<br>
•	Sort and paginate product results<br>


<br>

**User Authentication**<br>
•	User registration with password hashing using BCrypt<br>
•	Login using email and password<br>
•	Session-based authentication<br>
•	Retrieve the authenticated user's profile<br>
•	Role-based authorization structure<br>

<br>

**Data Persistence**<br>
•	Relational database integration using MySQL<br>
•	Entity mapping and persistence through JPA and Hibernate<br>
•	Shared product attributes managed through entity inheritance using JPA<br>

<br>

## Project Structure
The backend follows a layered architecture, with a clear separation of responsibilities across controllers, services, repositories, entities and configuration components.
The structure below highlights the main packages and classes included in this public repository. <br>
<br>
![Coffee District Backend Project Structure](screenshots/project-structure-backend.png)
<br>
<br>



## Architecture 
The application follows a layered architecture, with controllers handling HTTP requests and delegating business logic to services, which interact with repositories for data access.
<br>

- **Controllers:** Handle HTTP requests and expose REST endpoints<br>
- **Services:** Contain business logic<br>
- **Repositories:** Provide data access through Spring Data JPA<br>
- **Entities:** Model application data, including Product, Coffee, Cookie and Machine<br>
- **DTOs:** Define the data transferred between application layers and the frontend<br>
- **Config:** Contains application configuration, security and authentication components<br>
- **Enums:** Define application-specific values, including categories and user roles<br>

<br>



## API Endpoints Example
![API Endpoints Example - Postman](screenshots/api-overview.png)

<br>
<br>

**Example: Filtering and Pagination**<br>
The following endpoint demonstrates the combination of multiple filters, pagination and sorting in a single request. 
<br>

GET /coffees?country=brazil&brand= amazoniaroastery &aroma=chocolate&page=0&size=12&sort=price <br>

<br>

## API Testing
API endpoints were tested both manually and through automated Postman tests, covering successful requests, filtering, pagination, sorting and invalid product lookup<br>
<br>
The following screenshots demonstrate selected API requests and their corresponding responses. <br>
<br>


**Product Retrieval and Pagination** <br>  
![Product Retrieval and Pagination - Postman](screenshots/postman-retrieval_pagination.png)
<br>
<br>
**Product Filtering and Sorting**<br>  
![Product Filtering and Sorting - Postman](screenshots/postman-filtering_sorting.png)
<br>
<br>

**Invalid Product Lookup**<br>  
![Invalid Product Lookup - Postman](screenshots/postman-invalid_lookup.png)

<br>

## Running the Application
1.	Clone the repository
2.	Create a MySQL database named coffeedistrict.
3.	Configure the MySQL database connection in application.properties, including the database URL, username and password.
4.	Run the Spring Boot application
5.	Access the API at http://localhost:8080

<br>

## Project Status
**In progress:** enhanced exception handling and meaningful HTTP error responses <br>
**Future improvements:** Admin product management for CRUD operations <br>
**Scope limitation:**  No payment gateway or online payment processing is included <br>
