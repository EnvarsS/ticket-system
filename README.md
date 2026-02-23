# 🎟️ Event Ticketing Platform — Microservices Architecture

A fully event-driven microservices backend for an event ticketing platform, built with **Spring Boot**, **Apache Kafka**, **Spring Cloud**, and **MySQL**. The system handles user management, event browsing, venue management, booking, order processing, and ticket generation — all coordinated through asynchronous messaging and service discovery.

---

## 🏗️ Architecture Overview

```
Client
  └── API Gateway (port 4020)
        ├── user-service      (port 4013)
        ├── event-service     (port 4011)
        ├── venue-service     (port 4012)
        ├── booking-service   (port 4014)
        ├── order-service     (port 4015)
        └── ticket-service    (port 4016)

Service Registry: Eureka (port 4017)
Message Broker:   Apache Kafka + Zookeeper
```

All services register with **Eureka** for service discovery and communicate either via **OpenFeign** (synchronous) or **Kafka** (asynchronous/event-driven).

---

## 🧩 Services

### 🔐 service-registry
Eureka service registry. All other services register here on startup.

### 🌐 api-gateway
Spring Cloud Gateway that routes incoming HTTP requests to the correct downstream microservice based on path predicates:
- `/users/**` → user-service
- `/events/**` → event-service
- `/venues/**` → venue-service
- `/bookings/**` → booking-service
- `/orders/**` → order-service
- `/tickets/**` → ticket-service

### 👤 user-service
Manages users. Provides endpoints to list all users, get a user by ID, and check if a user exists.

### 🏟️ venue-service
Manages venue data (name, capacity, address). Pre-seeded with 6 Berlin venues.

### 📅 event-service
Manages events. Each event is linked to a venue, has a date, total/available capacity, and a ticket price. Exposes endpoints to fetch event details, capacity, and price, and to reduce available capacity after a booking.

### 📋 booking-service
Handles the initial booking request. Validates that the user exists (via Feign → user-service) and fetches the ticket price (via Feign → event-service), then publishes a `BookingEvent` to the **`booking`** Kafka topic.

**Booking Flow:**
1. `POST /bookings` received
2. User existence verified
3. Ticket price fetched
4. `BookingEvent` published to Kafka

### 📦 order-service
Listens on the **`booking`** Kafka topic. Creates an `Order` record, reduces event capacity via Feign, then publishes an `OrderCreatedEvent` to the **`order-created`** Kafka topic.

### 🎫 ticket-service
Listens on the **`order-created`** Kafka topic. Generates one `Ticket` per attendee name included in the order. Tickets are stored with a UUID primary key. Provides an endpoint to retrieve all tickets for a given user.

---

## 🔄 Event-Driven Flow

```
POST /bookings
    │
    ▼
booking-service
    │ (validates user + price via Feign)
    │
    ▼
Kafka topic: "booking"
    │
    ▼
order-service
    │ (saves order, reduces capacity via Feign)
    │
    ▼
Kafka topic: "order-created"
    │
    ▼
ticket-service
    │ (creates one ticket per attendee name)
    ▼
  Done ✓
```

---

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| **Java 21** | Core language |
| **Spring Boot 4.0.1** | Application framework |
| **Spring Cloud 2025.1.0** | Microservice tooling |
| **Spring Cloud Gateway** | API routing |
| **Spring Cloud Netflix Eureka** | Service discovery |
| **OpenFeign** | Synchronous inter-service HTTP calls |
| **Apache Kafka** | Asynchronous event messaging |
| **Spring Data JPA** | Database ORM |
| **Liquibase** | Database migrations |
| **MySQL** | Relational database (one DB per service) |
| **Lombok** | Boilerplate reduction |
| **ModelMapper** | Object mapping |
| **Docker Compose** | Local infrastructure orchestration |

---

## 🐳 Running Locally

### Prerequisites
- Java 21
- Maven
- Docker & Docker Compose

### 1. Start infrastructure
```bash
docker-compose up -d
```
This starts MySQL instances for each service, Apache Kafka, and Zookeeper.

| Container | Purpose | Port |
|---|---|---|
| events-db | MySQL for event-service | 3306 |
| venue-db | MySQL for venue-service | 3307 |
| user-db | MySQL for user-service | 3308 |
| order-db | MySQL for order-service | 3309 |
| ticket-db | MySQL for ticket-service | 3310 |
| kafka-broker | Apache Kafka | 9092 |
| zookeeper | Kafka coordination | 2181 |

### 2. Start services (in order)

```bash
# 1. Service Registry
cd service-registry && ./mvnw spring-boot:run

# 2. Core services
cd event-service && ./mvnw spring-boot:run
cd venue-service && ./mvnw spring-boot:run
cd user-service  && ./mvnw spring-boot:run

# 3. Business services
cd booking-service && ./mvnw spring-boot:run
cd order-service   && ./mvnw spring-boot:run
cd ticket-service  && ./mvnw spring-boot:run

# 4. API Gateway
cd api-gateway && ./mvnw spring-boot:run
```

---

## 📡 API Reference

### Bookings
```http
POST /bookings
Content-Type: application/json

{
  "userId": 1,
  "eventId": 1,
  "ticketCount": 2,
  "names": ["Alice Johnson", "Bob Smith"]
}
```

### Events
```http
GET /events
GET /events/{id}
GET /events/{id}/price
GET /events/{id}/capacity
```

### Users
```http
GET /users
GET /users/{id}
```

### Venues
```http
GET /venues
GET /venues/{id}
```

### Tickets
```http
GET /tickets?userId={userId}
```

---

## 🗄️ Database Schema

Each service owns its own database (Database-per-Service pattern):

- **users** — id, name, email, role (customer/admin/provider)
- **events** — id, name, total_capacity, available_capacity, date, venue_id, price
- **venues** — id, name, capacity, address
- **orders** — id, total_price, quantity, user_id
- **tickets** — id (UUID), order_id, event_id, user_id, name

Database migrations are managed by **Liquibase** and run automatically on startup.

---

## 📐 Design Patterns Used

- **Database per Service** — each microservice owns its own MySQL instance
- **Event-Driven Architecture** — booking → order → ticket pipeline via Kafka
- **API Gateway Pattern** — single entry point with path-based routing
- **Service Registry / Discovery** — Eureka for dynamic service location
- **Saga Pattern (choreography)** — distributed transaction managed via chained Kafka events
- **Anti-Corruption Layer** — each service defines its own event model classes

---

## ⚙️ Configuration

Each service supports `dev` and `prod` Spring profiles. The `dev` profile points to `localhost` for all dependencies; the `prod` profile uses Docker container hostnames.

Switch profiles with:
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```
