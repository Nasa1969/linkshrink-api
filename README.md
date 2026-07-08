# LinkShrink - Enterprise URL Shortener API
A highly scalable, production-ready URL shortener built with Java and Spring Boot. 

## 🚀 Architecture Highlights
* **Base62 Encoding:** Replaces standard UUIDs with a mathematical Base62 encoding algorithm to ensure zero collisions and minimal URL length.
* **Idempotent Link Creation:** Database verification prevents redundant rows when identical URLs are submitted sequentially.
* **Strict Input Validation:** Controller-level RegEx validation prevents processing overhead for malformed web requests.
## How to Run
1. Ensure you have Java 17+ installed.
2. Clone this repository:
   `git clone https://github.com/Nasa1969/linkshrink-api.git`
3. Navigate to the project folder:
   `cd linkshrink-api`
4. Run the application:
   `./mvnw spring-boot:run`
5. Access the API at: `http://localhost:8081`
