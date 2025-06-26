# Spring CRUD Base

A lightweight Java library for standardized CRUD logic in Spring Boot applications. It provides generic controller and service layers, DTO mapping with ModelMapper, pagination support, and logging — designed for rapid integration and maintainable REST APIs.

---

## 📦 Features
- Generic `BaseService` and `BaseController` for reusable CRUD endpoints
- Entity ↔ DTO mapping via **ModelMapper**
- REST pagination via Spring's `Pageable`
- Built-in logging with **Slf4j**
- Minimal setup, easily extended

## 🚀 Quick Setup
```xml
<dependency>
  <groupId>com.crud</groupId>
  <artifactId>springboot-base</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

> No extra configuration needed. Just extend the base classes and inject `ModelMapper`.

---

### English
[English Documentation (README_EN.md)](README_EN.md)

### Italian
[Italian Documentation (README_IT.md)](README_IT.md)

### Spanish
[Spanish Documentation (README_ES.md)](README_ES.md)
