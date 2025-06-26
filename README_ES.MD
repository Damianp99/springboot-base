## 🇪🇸 Español

### 📚 Descripción
Spring CRUD Base es una biblioteca modular para aplicaciones Spring Boot que proporciona una abstracción estandarizada para operaciones CRUD a través de servicios y controladores genéricos. Incluye:

- Mapeo Entity ↔ DTO con ModelMapper
- Paginación con `Pageable`
- Logging automático con Slf4j
- Estructura fácilmente extensible

### 🚀 Requisitos
- Java 21+
- Spring Boot 3.3+

### ⚙️ Instalación
```xml
<dependency>
  <groupId>com.crud</groupId>
  <artifactId>springboot-base</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### 🛠 Integración
1. Extiende `BaseServiceImpl<T, DTO, ID>` para la lógica
2. Extiende `BaseController<DTO, ID>` para los controladores REST
3. Inyecta `ModelMapper` configurado automáticamente
4. Añade DTO y repositorio para cada entidad

### 🌐 Ejemplo
```java
@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController<UserDTO, Long> {
    public UserController(UserService service) {
        super(service);
    }
}