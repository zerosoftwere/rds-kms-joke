FROM eclipse-temurin:25-jre
WORKDIR /app

COPY target/RDS-SSM-Joke-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar app.jar"]
