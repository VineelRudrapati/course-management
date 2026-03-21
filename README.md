# 📚 Course Management Microservices Platform

## 🚀 Overview

This project is a **scalable Course Management System** built using:

* **Java 21**
* **Spring Boot 3.x**
* **Spring Cloud (Microservices)**
* **Angular (Frontend - upcoming)**
* **PostgreSQL / MySQL**

It follows **microservices architecture**, where each service is **independently deployable, scalable, and loosely coupled**.

---

## 🧠 Problem Statement

To design a system that:

* Manages users and courses
* Allows users to enroll in courses
* Scales independently
* Avoids tight coupling between modules
* Supports real-world enterprise architecture

---

## 🏗️ Architecture

```
Angular UI
     │
     ▼
API Gateway
     │
     ▼
Service Registry (Eureka)
     │
 ┌───────────────┬───────────────┬───────────────┐
 │               │               │               │
User Service   Course Service  Enrollment     Auth Service
                                 Service
```

---

## 🔧 Microservices Breakdown

### 1️⃣ Service Registry (Eureka)

**Purpose:**

* Registers all services
* Enables service discovery

**Why?**

* Avoid hardcoded URLs
* Handle dynamic scaling

---

### 2️⃣ API Gateway

**Purpose:**

* Entry point for all client requests
* Routes requests to appropriate services

**Why?**

* Centralized routing
* Security layer
* Reduces frontend complexity

---

### 3️⃣ User Service

**Responsibilities:**

* Manage user data
* Store user profiles

**Why separate?**

* Central identity service
* Reusable across system

---

### 4️⃣ Course Service

**Responsibilities:**

* Manage course catalog
* Create/update/delete courses

**Why separate?**

* High read operations
* Admin-driven service

---

### 5️⃣ Enrollment Service

**Responsibilities:**

* Manage user-course relationships
* Track enrollments

**Why separate?**

* Decouples user and course domains
* Handles business logic independently

---

### 6️⃣ Auth Service (Upcoming)

**Responsibilities:**

* Authentication & authorization
* JWT token generation

---

### 7️⃣ Notification Service (Upcoming)

**Responsibilities:**

* Send emails/SMS
* Event-driven communication

---

## 🗂️ Project Structure (Per Service)

```
controller/     → REST endpoints
service/        → Business logic
repository/     → Data access layer
entity/         → Database mapping
dto/            → API request/response models
exception/      → Error handling
config/         → Configuration classes
client/         → Feign clients (inter-service calls)
```

---

## 🔑 Key Concepts Used

### ✅ Microservices Architecture

* Independent services
* Decentralized data

### ✅ API Gateway Pattern

* Single entry point
* Request routing

### ✅ Service Discovery (Eureka)

* Dynamic service lookup

### ✅ DTO Pattern

**Why needed?**

* Decouples API from DB
* Prevents exposing internal structure
* Supports versioning

---

### ✅ Layered Architecture

```
Controller → Service → Repository → Database
```

**Why?**

* Separation of concerns
* Easier testing and maintenance

---

### ✅ Spring Data JPA

**Why?**

* Eliminates boilerplate JDBC code
* Provides ORM capabilities

---

### ✅ Validation

**Why?**

* Ensures data integrity
* Prevents invalid requests

---

## 🛠️ Technologies Used

| Technology       | Purpose               |
| ---------------- | --------------------- |
| Spring Boot      | Application framework |
| Spring Cloud     | Microservices support |
| Eureka           | Service discovery     |
| API Gateway      | Routing               |
| JPA (Hibernate)  | ORM                   |
| PostgreSQL/MySQL | Database              |
| Angular          | Frontend (planned)    |

---

## ⚙️ How to Run

### Step 1: Start Service Registry

```
Run ServiceRegistryApplication
Access: http://localhost:8761
```

---

### Step 2: Start API Gateway

```
Run ApiGatewayApplication
Verify in Eureka dashboard
```

---

### Step 3: Start User Service

```
Run UserServiceApplication
```

---

### Step 4: Verify Services

* Open Eureka dashboard
* Ensure all services are **UP**

---

## 🔄 Request Flow

```
Client → API Gateway → Service → Database
```

Example:

```
GET /api/users/1
→ Gateway
→ User Service
→ DB
→ Response
```

---

## 🚧 Future Enhancements

* 🔐 JWT Authentication
* 🔄 Circuit Breaker (Resilience4j)
* 📦 Docker & Kubernetes
* 📊 Monitoring (Prometheus + Grafana)
* 🔔 Event-driven architecture (Kafka)

---

## 🧠 Interview Key Points

* Each microservice owns its database
* DTO prevents tight coupling
* Gateway simplifies client communication
* Eureka removes hardcoded service URLs
* Services communicate via Feign
