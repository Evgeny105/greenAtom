FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/file-service-1.0.0.jar file-service.jar
ENTRYPOINT ["java", "-jar", "/file-service.jar"]
