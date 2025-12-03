# Java SaaS Boilerplate (Backend)

This is an enterprise-grade backend boilerplate built with Java 21 and Spring Boot 4. It provides a solid foundation for building secure and scalable SaaS applications.

## 🚀 Tech Stack

- **Framework:** [Spring Boot 4](https://spring.io/projects/spring-boot)
- **Language:** Java 21
- **Build Tool:** Maven
- **Database Access:** Spring Data JPA
- **Database:** PostgreSQL
- **Security:** Spring Security & JWT (`jjwt`)
- **Documentation:** SpringDoc OpenAPI (Swagger)
- **Utilities:** Lombok

## 🛠️ Getting Started

### Prerequisites

- Java Development Kit (JDK) 21
- Maven (or use the included `mvnw` wrapper)
- PostgreSQL Database

### Installation

1. Navigate to the project directory:
   ```bash
   cd java/backend
   ```

2. Configure the database:
   Update `src/main/resources/application.properties` (or `application.yml`) with your PostgreSQL credentials.

### Running the Application

You can run the application using the Maven wrapper:

```bash
./mvnw spring-boot:run
# On Windows:
# mvnw.cmd spring-boot:run
```

The application will start on port 8080 (default).
API Documentation (Swagger UI) is available at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) (or `/swagger-ui/index.html`).

### Building for Production

To build a self-contained JAR file:

```bash
./mvnw clean package
```

The JAR file will be generated in the `target/` directory.

## 📂 Project Structure

- `src/main/java`: Java source code.
- `src/main/resources`: Configuration files and static resources.
- `src/test`: Unit and integration tests.

## 🔐 Security

The project is configured with Spring Security and uses JWT for stateless authentication. Ensure you configure your JWT secret in the application properties.
