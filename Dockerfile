# FROM maven:3.6.3-openjdk-17-slim AS build_stage

# #set working dir as an active folder on container
# WORKDIR /app

# COPY pom.xml .
# COPY src ./src

# # build app using maven
# RUN mvn clean package -DskipTests


# #user openJDK as base image
# FROM openjdk:17.0.2-jdk-slim

# WORKDIR /app

# #copy built jar from prev stage (maven as Build) to container
# COPY --from=build_stage /app/build/app.jar .

# #command to run the app
# CMD [ "java", "-jar", "app.js" ]


FROM maven:3.6.3-openjdk-17-slim AS build_stage


# # # Build the application
# # RUN ./mvnw clean package -DskipTests
# # Copy Maven files for dependency resolution
COPY pom.xml .
# COPY .mvn .mvn

# # Copy application source code
# COPY . .
RUN mvn -e -B dependency:resolve
COPY src ./src

# Build the project and create the executable JAR
RUN mvn clean -e -B package -DskipTests


FROM eclipse-temurin:17.0.10_7-jre-jammy

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build_stage /target/*.jar .

# Command to run the application
CMD ["java", "-jar", "sekolah_app.1.0.0.jar"]