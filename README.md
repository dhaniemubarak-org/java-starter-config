# Getting Started
This project for help The Alto Team for an init project with Spring Boot. 
The project has included some configuration like as database, kafka, and redis. 
You only need the credential what you have, and you can remove dependencies what you didn't need.
Some conditions for now like bellow:
* Java 11
* Spring Boot 2.7 with Maven
* This project package name uses 'id.alto.javastarterconfig'.
* Database postgresql
* Apache Kafka
* Redis

## Configure 
### Package name
You can change the package name with refactor the project in directory path : <br/>
`src/main/java/id/alto/javastarterconfig` to `src/main/java/id/alto/<your-project-name>` and <br/>
`src/test/java/id/alto/javastarterconfig` to `src/test/java/id/alto/<your-project-name>` <br/>
And also change artifact id, name and description in `pom.xml`
### Dependencies
Default dependencies are :
* spring boot starter data jpa
* spring boot starter redis
* spring boot starter web
* spring kafka
* postgresql
* lombok

You can remove the dependencies as you need and remove example code too.


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.11/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.11/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.11/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.11/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Data Redis (Access+Driver)](https://docs.spring.io/spring-boot/docs/2.7.11/reference/htmlsingle/#data.nosql.redis)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.7.11/reference/htmlsingle/#messaging.kafka)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)

