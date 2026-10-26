# REST API Automation Framework

API automation framework built with REST Assured and JUnit 5 to validate RESTful web services, using [JSONPlaceholder](https://jsonplaceholder.typicode.com) as the target test API.

## Tech Stack
- Java
- REST Assured
- JUnit 5
- Maven
- JSON Schema Validation

## Test Coverage
- **GET** — fetch single resource, fetch list, 404 handling, JSON schema validation
- **POST** — create resource, validate response echoes submitted data
- **PUT** — update resource, validate updated fields
- **DELETE** — remove resource, validate status code

## Project Structure
```
src/main/java/com/ritesh/apiautomation/
 └── utils/
      └── ApiUtils.java        # Reusable request specification (base URI, headers)

src/test/java/com/ritesh/apiautomation/tests/
 ├── GetPostTest.java
 ├── CreatePostTest.java
 └── UpdateAndDeletePostTest.java

src/test/resources/schemas/
 └── post-schema.json          # JSON schema used to validate GET response structure
```

## How to Run
```bash
mvn test
```

Requires Java 17+ and Maven. No API key or account setup needed — JSONPlaceholder is a free public test API.

## Author
Ritesh Kumar
