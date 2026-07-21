# Reservation Service

Minimal Spring Boot reservation backend prepared for further development.

## Technology

- Java 17
- Spring Boot 3.5
- Spring Web
- Spring Data JPA
- H2 database
- Maven

## Build and test

```bash
mvn --batch-mode verify
```

## Run locally

```bash
mvn spring-boot:run
```

The repository currently contains the Maven project definition only. Application source code and domain-specific tests should be added before the service is considered production-ready.

## Planned domain scope

- room types and capacities
- current room occupancy
- reservations and reserving-person details
- unit and integration tests for reservation rules

## Quality and security

GitHub Actions verifies the Maven build on every push and pull request. Dependabot checks Maven and GitHub Actions dependencies weekly.
