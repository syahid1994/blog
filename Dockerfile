FROM maven:3.8.3-openjdk-17
RUN mvn clean install -DskipTests

FROM openjdk:17
EXPOSE 8080
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]