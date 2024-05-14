# Build
FROM maven:3.9.6-eclipse-temurin-22-alpine AS build
COPY src /app/src/
COPY pom.xml /app/
WORKDIR /app
RUN mvn clean package

# Run
FROM eclipse-temurin:22-jre-alpine
COPY --from=build /app/target/post-message-service-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/app/postservicews-0.0.1-SNAPSHOT.jar"]