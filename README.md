# Online Course System Spring Boot, Angular 7, Cassandra, Docker

The application structure is as follows.
- **course-server** - Server side implemented using Spring boot. [More info](course-server/README.md)
- **course-client** - A NodeJs application implemented using Angular 7. This consumes services hosted by server side.  [More info](course-client/README.md)
- **docker-compose.yml** - Docker compose file to run server side and course-client in container.

### Build

#### 1) Build Docker images and run it in containers using docker-compose from parent directory.
   This also create container for Cassandra and run it.
   
```
$ docker-compose up
```

NOTE: To run without docker container follow [steps](course-server/README.md) in course-server project.

#### 2) Build and run course-client application (Important: docker-compose up will handle everything so this is not necessary part.)

```
$ cd course-client
$ docker build -t course-client .
$ docker run -d -p 4200:80 course-client
```

### Access application using following URL

```
http://localhost:4200
```

