## 🇬🇧 English

### 📚 Description
Spring CRUD Base is a modular library for Spring Boot applications that provides standardized abstraction for CRUD operations through generic services and controllers. It includes:

- Entity ↔ DTO mapping via ModelMapper
- Built-in pagination (`Pageable`)
- Logging via Slf4j
- Easily overridable structure for custom logic

### 🚀 Requirements
- Java 21+
- Spring Boot 3.3.x

### ⚙️ Installation
```xml
<dependency>
  <groupId>com.crud</groupId>
  <artifactId>springboot-base</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### 🛠 Integration
1. Extend `BaseServiceImpl<T, DTO, ID>` for business logic
2. Extend `BaseController<DTO, ID>` for REST controllers
3. Inject preconfigured `ModelMapper`
4. Add DTO and repository per entity

### 🌐 Example
```java
@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController<UserDTO, Long> {
    public UserController(UserService service) {
        super(service);
    }
}