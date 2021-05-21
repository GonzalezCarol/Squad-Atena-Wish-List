# Squad-Atena-Wish-List

## Requirements Backend
Java - 1.8.x

Maven - 3.x.x

## Setup

Clone the application
git clone git@github.com:GonzalezCarol/Squad-Atena-Wish-List.git

Install dependencies
$ mvn install

Build and run the app using maven
mvn spring-boot:run The app will start running at http://localhost:8080.

Explore Rest APIs SWaggger http://localhost:8080/swagger-ui.html

Make a GET request to /api/products to check you're not authenticated. You should receive a response with a 403 with an Access Denied message since you haven't set your valid JWT token yet
$ http://localhost:8080/api/products

Make a POST request to /api/signin with the default admin user we programatically created to get a valid JWT token
$ http://localhost:8080/api/signin?username=admin&password=admin

Add the JWT token as a Header parameter and make the initial GET request to /users/me again
$ http://localhost:8080/api/products  with 'Authorization: Bearer <JWT_TOKEN>'


You can test them using insomninia, swagger or any other rest client.
