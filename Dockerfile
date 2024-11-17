FROM openjdk:17
EXPOSE 8080
ADD target/spring-security.jar spring-security.jar
ENTRYPOINT ["java", "-jar", "/spring-security.jar"]