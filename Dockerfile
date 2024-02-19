FROM maven:3.6.3-openjdk-17-slim AS build_stage

#set working dir as an active folder on container
WORKDIR /app

COPY pom.xml .
COPY src ./src

# build app using maven
RUN mvn clean package -DskipTests


#user openJDK as base image
FROM openjdk:17.0.2-jdk-slim

WORKDIR /app

#copy built jar from prev stage (maven as Build) to container
COPY --from=build_stage /app/build/app.jar .

#command to run the app
CMD [ "java", "-jar", "app.js" ]


