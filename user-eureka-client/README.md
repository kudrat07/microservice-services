# 🚀 Spring Boot Eureka Client (Service Registration)

This project contains a **Eureka Client** implementation using **Spring Boot**.
A Eureka Client is a microservice that **registers itself with the Eureka Server** and discovers other services dynamically without hardcoding URLs.

---

## 📌 What is Eureka Client?

A **Eureka Client** is any microservice that connects to a Eureka Server to:

* Register itself automatically
* Discover other microservices using service names
* Enable communication between services in a distributed system

Instead of calling services using IP address and port, services communicate using:

```
http://SERVICE-NAME/api
```

---

## ✅ Why Use Eureka Client?

* Automatic service registration
* Dynamic service discovery
* No hardcoded service URLs
* Supports load balancing
* Enables scalable microservices architecture
* Fault-tolerant communication

---

## 🏗️ How It Works

1. Eureka Server runs first.
2. Eureka Client starts.
3. Client registers itself with Eureka Server.
4. Client sends periodic heartbeat signals.
5. Other services discover it using its service name.

Example:

```
user-service → registers → Eureka Server
order-service → discovers → user-service
```

---

## ⚙️ Step-by-Step: Create Eureka Client

### 1️⃣ Create Spring Boot Project

Create a normal Spring Boot microservice using:

* Spring Initializr (https://start.spring.io)
* IntelliJ / STS

#### Project Setup

* Project: Maven
* Language: Java
* Spring Boot: 3.x
* Packaging: Jar

---

### 2️⃣ Add Required Dependency

Add Eureka Client dependency.

### Maven Dependency (`pom.xml`)

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

---

### 3️⃣ Add Spring Cloud Dependency Management

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>2023.0.1</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

---

## 🧩 Enable Eureka Client

In modern Spring Boot versions, Eureka Client is auto-enabled when the dependency is added.

Optionally, you may add:

```java
@EnableDiscoveryClient
```

### Main Application Class

```java
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
```

---

## ⚙️ Configuration File Setup

Create or update:

```
src/main/resources/application.yml
```

### Example Configuration

```yaml
server:
  port: 8081

spring:
  application:
    name: user-service

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
    register-with-eureka: true
    fetch-registry: true
```

---

### 🔍 Configuration Explanation

| Property                  | Purpose                           |
| ------------------------- | --------------------------------- |
| `server.port`             | Port on which microservice runs   |
| `spring.application.name` | Service name registered in Eureka |
| `defaultZone`             | Eureka Server URL                 |
| `register-with-eureka`    | Registers service automatically   |
| `fetch-registry`          | Fetches other registered services |

---

## ▶️ Running the Eureka Client

Make sure **Eureka Server is running first**.

Run the service:

```
mvn spring-boot:run
```

or run as Spring Boot application from IDE.

---

## 🌐 Verify Registration

Open Eureka Dashboard:

```
http://localhost:8761
```

You should see your service listed under:

```
Instances currently registered with Eureka
```

Example:

```
USER-SERVICE
```

---

## 🔄 Service-to-Service Communication

Once registered, services can communicate using service name:

```
http://USER-SERVICE/api/users
```

Load balancing automatically distributes requests among instances.

---

## 📂 Project Structure

```
user-service
│
├── src/main/java
│   └── com.example.userservice
│       └── UserServiceApplication.java
│
├── src/main/resources
│   └── application.yml
│
└── pom.xml
```

---

## 🧠 Important Notes

* Eureka Server must start before clients.
* Service name must be unique.
* Heartbeats keep service alive in registry.
* If heartbeat stops, Eureka removes the instance automatically.

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Cloud Netflix Eureka Client
* Maven

---

## 📌 Future Enhancements

* Add API Gateway integration
* Implement Load Balancing
* Add Circuit Breaker (Resilience4j)
* Centralized configuration using Config Server

---

## 👨‍💻 Author

Spring Boot microservice configured as Eureka Client for service discovery and inter-service communication.
