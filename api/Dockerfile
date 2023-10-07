FROM maven:3.9.4-eclipse-temurin-17-alpine AS buildstage
WORKDIR /app
COPY . .
RUN mvn package

FROM openjdk:17-jdk-alpine AS runstage
COPY --from=buildstage ./app/target/api-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]