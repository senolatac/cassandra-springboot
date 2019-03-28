# Course-Server

This project is a Spring Boot and Cassandra project.

## Development server

Run `Course-Server Main class` for a dev server. Navigate to `http://localhost:8080/`. The app will automatically reload if you change any of the source files.

## Build

Run `gradlew clean build`

java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar app.jar
