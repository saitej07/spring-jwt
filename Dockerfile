FROM openjdk:17
EXPOSE 8080
ADD target/spring-jwt.jar spring-jwt.jar
ENTRYPOINT["java","-jar","/spring-jwt.jar"]