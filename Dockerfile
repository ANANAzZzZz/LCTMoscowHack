FROM openjdk:17
ARG JAR_FILE=target/*.jar
EXPOSE 8080
WORKDIR /app
COPY ./target/MoscowHack-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
