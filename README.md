# RenderJoke

A simple Kotlin Spring Boot application that manages jokes.

## Features
- REST endpoints for CRUD on jokes
- Flyway migrations (DB schema + sample data)
- Postgres database configuration via environment variables
- OpenAPI/Swagger UI for API exploration

## Running locally (Docker)

Start PostgreSQL:
```bash
docker-compose up -d
```

Run the application with Maven:
```bash
./mvnw spring-boot:run
```

The app will attempt to connect to Postgres using environment variables:
- JDBC_DATABASE_URL (default: jdbc:postgresql://localhost:5432/renderjoke)
- JDBC_DATABASE_USERNAME (default: renderjoke)
- JDBC_DATABASE_PASSWORD (default: password)

Swagger UI is available at: http://localhost:8080/swagger-ui.html

## Notes
- Flyway will apply the initial migration and prepopulate the database with sample jokes at startup.
