FROM eclipse-temurin:25

WORKDIR /app

COPY target/*.jar spring-rest.jar

EXPOSE 8081

ENTRYPOINT [ "java", "-jar", "spring-rest.jar" ]
