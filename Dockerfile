#FROM ubuntu:latest
#LABEL authors="saitejapulluri"
#
#ENTRYPOINT ["top", "-b"]
# Stage 1: Build the application
FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Stage 2: Copy the JAR file to a slim image
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/starwars-0.0.1-SNAPSHOT.jar starwars.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "starwars.jar"]
