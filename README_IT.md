# Spring CRUD Base

Libreria generica per la gestione CRUD in Spring Boot con supporto a DTO, ModelMapper, paginazione e logging.

---

## 🇮🇹 Italiano

### 📚 Descrizione
Spring CRUD Base è una libreria modulare per applicazioni Spring Boot che fornisce un'astrazione standardizzata per gestire le operazioni CRUD tramite controller e servizi generici, con supporto per:

- Mapping Entity ↔ DTO tramite ModelMapper
- Logging automatico con Slf4j
- Paginazione REST `Pageable`
- Override semplice per controller o logiche custom

### 🚀 Requisiti
- Java 21 o superiore
- Spring Boot 3.3+

### ⚙️ Installazione
```xml
<dependency>
  <groupId>com.crud</groupId>
  <artifactId>springboot-base</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### 🛠 Integrazione
1. Estendi `BaseServiceImpl<T, DTO, ID>` per la logica CRUD
2. Estendi `BaseController<DTO, ID>` per i controller
3. Inietta `ModelMapper` (già configurato tramite auto-config)
4. Aggiungi DTO e repository per ogni entità

### 🌐 Esempio
```java
@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController<UserDTO, Long> {
    public UserController(UserService service) {
        super(service);
    }
}