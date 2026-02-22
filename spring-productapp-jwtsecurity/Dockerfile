# Stage 1 - Build the JAR using Maven
FROM maven:3.9-eclipse-temurin-25 AS builder

WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2 - Run the app
FROM eclipse-temurin:25

WORKDIR /app

COPY --from=builder /build/target/*.jar product-restapi.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "product-restapi.jar"]
