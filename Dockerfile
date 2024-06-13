FROM openjdk:11

MAINTAINER author=spring.fire

COPY target/spring-boot-fire-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
