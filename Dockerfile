# Build
FROM eclipse-temurin:22-jre-alpine as build
WORKDIR /app
COPY provider/target/post-message-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "/app", "-jar", "post-message-service-0.0.1-SNAPSHOT.jar"]
# Use a GraalVM base image
#FROM oracle/graalvm-ce:latest AS graalvm

# Set a working directory within GraalVM
#WORKDIR /workspace

# Copy the Maven pom.xml file to the working directory
#COPY pom.xml .

# Build the project with GraalVM
#RUN gu install native-image
#RUN mvn package -Pnative-image -DskipTests

# Use a Alpine base image as the primary base image
#FROM  eclipse-temurin:22-jre-alpine

# Install MongoDB
#RUN apk add --no-cache mongodb-tools

# Set a working directory within the OpenJDK image
#WORKDIR /app

# Copy the finished native executable file from GraalVM to the working directory
#COPY --from=graalvm /workspace/target/post-message-service .

# Expose the port that your Spring Boot application listens on
#EXPOSE 8000

# Set the start command to run the finished application
#CMD ["./post-message-service"]



#Install Maven 3.9.6
#RUN curl https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz -o /tmp/maven.tar.gz \
#    && tar xf /tmp/maven.tar.gz -C /opt \
#    && ln -s /opt/apache-maven-3.9.6 /opt/maven \
#    && ln -s /opt/maven/bin/mvn /usr/bin/mvn \
#    && rm /tmp/maven.tar.gz \

#Set Maven Home
#WORKDIR /app

# Copy application files to the container
#COPY . /app
#COPY pom.xml /app

# Build the application using Maven
#RUN mvn package

# Build the native image using GraalVM
#RUN native-image

#CMD
#CMD ["./post-message-service"]