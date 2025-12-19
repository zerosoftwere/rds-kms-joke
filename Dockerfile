FROM eclipse-temurin:25-jre
WORKDIR /app

COPY target/RenderJoke-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar app.jar"]
