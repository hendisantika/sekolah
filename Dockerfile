FROM maven:3.6.3-openjdk-17-slim AS build_stage


COPY pom.xml .

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