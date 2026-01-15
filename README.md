# Topup Service

[GitHub Repository](https://github.com/3ramesh/topup-service)

## Overview
Topup Service is a Spring Boot application that handles top-up operations for accounts.  
It communicates with **Account Service** to perform transfers and keeps a record of top-up transactions in its own database.

Key responsibilities:
- Initiate a top-up request
- Call Account Service to perform transfer
- Track top-up status (success or failed)
- Proper validation and error handling

---

## Features
- Top-up money from one account to another via Account Service
- Persist top-up history in `topup_db`
- Request validation (`@NotBlank`, `@NotNull`, `@Positive`)
- Proper success/failure handling with custom messages
- Integration with Account Service via REST client

---

## Technologies
- Java 21
- Spring Boot 3.4
- Spring Data JPA
- MySQL 8 (`topup_db`)
- RestClient for inter-service communication
- MapStruct
- Lombok
- Maven
- Hibernate
- Spring Validation

---

## Prerequisites
- Java 21+
- Maven
- MySQL database running locally
- CREATE database topup_db
- Account Service running on `http://localhost:8081`

---

## Setup & Run

### 1. Clone the repository
```bash
git clone https://github.com/3ramesh/topup-service.git
cd topup-service
git checkout master
