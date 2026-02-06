# Personal Note Backend

Spring Boot REST API for managing personal notes.

## Tech stack
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 (in-memory)
- Maven Wrapper

## Prerequisites
- Java 17+ installed

## Run locally
- Windows (PowerShell)
  - mvnw.cmd spring-boot:run
- macOS/Linux
  - ./mvnw spring-boot:run

The API runs on http://localhost:8080 by default.

## API endpoints
Base path: /api/notes
- GET /api/notes
- GET /api/notes/{id}
- POST /api/notes
- PUT /api/notes/{id}
- DELETE /api/notes/{id}
- DELETE /api/notes

## CORS
Allowed origins are configured in application.properties:
- app.cors.allowed-origins=https://personalfrontend.vercel.app

To allow multiple origins, provide a comma-separated list:
- app.cors.allowed-origins=https://personalfrontend.vercel.app,https://another.example.com

## H2 console
Enabled at http://localhost:8080/h2-console

## Tests
- mvnw.cmd test
- ./mvnw test

### ✅ Backend Screenshots
1. Render dashboard → Service running  
2. API URL opened in browser (`/api/notes`)  
3. Docker container running (`docker ps`)  
4. Postman or browser showing JSON response  

## Screenshots

### Development backend
Command:

```
mvnw.cmd spring-boot:run
```

![Development backend](screenshot/Development%20Backend.png)

### Docker image build
Command:

```
docker build -t personalnote-backend .
```

![Docker image build](screenshot/Docker%20Image%20Build.png)

### Rendering
Command:

```
mvnw.cmd spring-boot:run
```

![Rendering](screenshot/rendering.png)

### Sonar analysis
Command:

```
mvnw.cmd sonar:sonar
```

![Sonar analysis](screenshot/Sonar%20Analysis(Backend).png)

### Proper pull request (Backend)
Command:

```
git push origin <branch-name>
```

![Proper pull request (Backend)](screenshot/Proper%20pull%20request(Backend).png)
