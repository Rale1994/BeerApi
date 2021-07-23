BeerAPI

To create this API I use Spring Boot.

The architecture of my project consists of several packages: - controller
                                                             - entity
                                                             - exception
                                                             - repository
                                                             - service
                                                             - validators

When we want to start this project we can start from BeerApiApplication class.

The controller package contains the BeerController class file that contains all endpoints for this assignment.

The entity package contains entity class Beer, in this class I define my domain class with all annotation filed for database.

In the exception package has custom beer exception with name BeerException.

Repository package contains BeerRepository interface who extends JpaRepository interface.

Service package contains BeerService class who implemented BeerRepository interface and gives us the ability to work with CRUD functions with a database.

In validators package has FieldValidator class which help me to validate some filed.

For database I use MySql and JPA technologies.

All endpoints were tested in Postman.