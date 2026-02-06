# 📗 BACKEND README  
📂 Repository: `personalbackend`

```md
# Personal Notes Organizer – Backend

## 📌 Project Overview
This backend provides RESTful APIs for managing personal notes.  
It supports full CRUD operations and is containerized using Docker and deployed on **Render**.

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


The API runs on http://localhost:8080 by default.

## ✨ Features
- Create notes
- Retrieve all notes
- Update notes
- Delete notes
- CORS enabled for frontend integration
- Dockerized backend service

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|------|--------|-------------|
| GET | `/api/notes` | Get all notes |
| POST | `/api/notes` | Create a new note |
| PUT | `/api/notes/{id}` | Update a note |
| DELETE | `/api/notes/{id}` | Delete a note |

---

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

## Screenshots

### Development backend


![Development backend](screenshot/Development%20Backend.png)

### Docker image build


docker build -t personalnote-backend .


![Docker image build](screenshot/Docker%20Image%20Build.png)

### Rendering


![Rendering](screenshot/rendering.png)

### Sonar analysis


![Sonar analysis](screenshot/Sonar%20Analysis(Backend).png)

### Proper pull request (Backend)


![Proper pull request (Backend)](screenshot/Proper%20pull%20request(Backend).png)
