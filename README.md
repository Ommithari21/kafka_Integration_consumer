# Kafka Consumer Service

A Spring Boot microservice that consumes order messages from Kafka, processes the data, calculates the total order value, and stores the result in MySQL.

## Features

* Kafka message consumption
* Order processing
* Total price calculation
* MySQL persistence
* Spring Data JPA integration

## Tech Stack

* Java
* Spring Boot
* Apache Kafka
* Spring Data JPA
* MySQL
* Maven

## Project Structure

```text
src
├── Entity
│   └── Order
├── Repository
│   └── OrderRepository
├── Service
│   └── KafkaConsumerService
└── resources
    └── application.properties
```

## Processing Logic

When a message is received from Kafka:

1. Consume order message
2. Calculate total price
3. Add processing timestamp
4. Save record into MySQL

### Formula

```text
total_price = quantity × price
```

## Sample Input Message

```json
{
  "id": "101",
  "product_name": "Laptop",
  "quantity": 2,
  "price": 50000
}
```

## Sample Stored Record

```json
{
  "id": "101",
  "product_name": "Laptop",
  "quantity": 2,
  "price": 50000,
  "total_price": 100000,
  "process_date": "2026-06-22T12:30:00"
}
```

## Data Flow

```text
Kafka Topic
     │
     ▼
Consumer Service
     │
     ▼
Process Order
     │
     ▼
MySQL Database
```

## Run Locally

```bash
mvn clean install
mvn spring-boot:run
```

## Purpose

This service is responsible for consuming Kafka messages, performing business logic, and storing processed data in the database.
