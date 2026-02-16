# 🚀 Spring Boot Eureka Server (Service Discovery)

This project contains a **Netflix Eureka Server** implementation using **Spring Boot Microservices architecture**. Eureka acts as a **Service Registry** where all microservices register themselves and discover other services dynamically.

---

## 📌 What is Eureka Server?

**Eureka Server** is a **Service Discovery Server** provided by Netflix and integrated into Spring Cloud.

In a microservices architecture, services run on different ports and multiple instances. Instead of hard-coding service URLs, services register themselves with Eureka, and other services discover them using service names.

### ✅ Why Eureka is Needed

* Avoid hardcoded service URLs
* Dynamic service discovery
* Load balancing support
* Automatic service registration
* Handles scaling (multiple instances)
* Improves fault tolerance

---

## 🏗️ Architecture Flow

1. Eureka Server starts first.
2. Microservices register themselves with Eureka.
3. Each service sends heartbeat signals.
4. Other services discover them using the service name instead of IP/Port.

Example:

```
user-service → registers → Eureka Server
order-service → asks Eureka → finds user-service
```

---

## ⚙️ Step-by-Step: How to Create Eureka Server

### 1️⃣ Create Spring Boot Project

You can create the project using:

* Spring Initializr (https://start.spring.io)
* IDE (STS / IntelliJ)

#### Required Project Details

* Project: Maven
* Language: Java
* Spring Boot: 3.x
* Packaging: Jar

---

### 2️⃣ Add Required Dependency

Add **Eureka Server Dependency**.

#### Maven Dependency (`pom.xml`)

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
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

## 🧩 Enable Eureka Server

Add the following annotation in the main application class:

```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

### ✅ What this annotation does

`@EnableEurekaServer` converts your Spring Boot application into a **Service Registry Server**.

---

## ⚙️ Configuration File Setup

Create or update:

```
src/main/resources/application.yml
```

### Example Configuration

```yaml
server:
  port: 8761

spring:
  application:
    name: eureka-server

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

---

### 🔍 Configuration Explanation

| Property                  | Purpose                            |
| ------------------------- | ---------------------------------- |
| `server.port`             | Runs Eureka dashboard on port 8761 |
| `spring.application.name` | Name of Eureka application         |
| `register-with-eureka`    | Server should NOT register itself  |
| `fetch-registry`          | Server does not need registry data |
| `defaultZone`             | Eureka server URL                  |

---

## ▶️ Running the Eureka Server

Run the application:

```
mvn spring-boot:run
```

or

```
Run as → Spring Boot App
```

---

## 🌐 Access Eureka Dashboard

Open browser:

```
http://localhost:8761
```

You will see the Eureka dashboard showing registered services.

---

## 🔄 How Microservices Connect to Eureka

Client services must:

1. Add Eureka Client dependency
2. Configure Eureka URL
3. Enable discovery client

Example:

```yaml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

---

## ✅ Key Advantages

* Dynamic service discovery
* Supports microservice scaling
* Removes manual configuration
* Works with Spring Cloud LoadBalancer
* Improves system resilience

---

## 📂 Project Structure

```
eureka-server
│
├── src/main/java
│   └── com.example.eureka
│       └── EurekaServerApplication.java
│
├── src/main/resources
│   └── application.yml
│
└── pom.xml
```

---

## 🧠 Important Notes

* Eureka Server must start **before** all microservices.
* All services should use the same Eureka URL.
* Default heartbeat interval keeps services alive.
* If a service stops sending heartbeat, Eureka removes it automatically.

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Cloud Netflix Eureka
* Maven

---

## 📌 Future Improvements

* Add API Gateway (Spring Cloud Gateway)
* Enable Load Balancing
* Centralized Config Server
* Distributed Tracing (Zipkin)
* Circuit Breaker (Resilience4j)

---

## 👨‍💻 Author

Microservices implementation using Spring Boot and Eureka for scalable service discovery.

