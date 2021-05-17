https://github.com/gstearmit/spring-testing

https://github.com/EpayVNTech/core-service/commit/2f87b2f6c7b46e51fb1e95666a7061089148eb50

Test tren Postman : 

 

JUnit - https://junit.org/junit5/docs/current/user-guide/
AssertJ - https://joel-costigliola.github.io/assertj/
Mockito - https://github.com/mockito/mockito/wiki/FAQ
JsonPath - https://github.com/json-path/JsonPath
Setting up JUnit 5 with Mockito and Spring Boot 2.0 - https://medium.com/@dSebastien/using-junit-5-with-spring-boot-2-kotlin-and-mockito-d5aea5b0c668
Good Unit Testing
https://github.com/mockito/mockito/wiki/How-to-write-good-tests
FIRST. https://pragprog.com/magazines/2012-01/unit-tests-are-first
Patterns - http://xunitpatterns.com
Mocking Static, Private Methods and Constructors
https://github.com/in28minutes/MockitoTutorialForBeginners/blob/master/Step15.md
https://github.com/in28minutes/MockitoTutorialForBeginners/tree/master/src/test/java/com/in28minutes/powermock


## Test Layers
The example applicationn shows different test layers according to the [Test Pyramid](https://martinfowler.com/bliki/TestPyramid.html).

```
      ╱╲
  End-to-End
    ╱────╲
   ╱ Inte-╲
  ╱ gration╲
 ╱──────────╲
╱   Unit     ╲
──────────────
```

## Application Architecture

```
 ╭┄┄┄┄┄┄┄╮      ┌──────────┐      ┌──────────┐
 ┆   ☁   ┆  ←→  │    ☕     │  ←→  │    💾     │
 ┆  Web  ┆ HTTP │  Spring  │      │ Database │
 ╰┄┄┄┄┄┄┄╯      │  Service │      └──────────┘
                └──────────┘
                     ↑ JSON/HTTP
                     ↓
                ┌──────────┐
                │    ☁     │
                │ Strip  │
                │   API    │
                └──────────┘
```

### Internal Architecture
The **Spring Service** itself has a pretty common internal architecture:

  * `Controller` classes provide _REST_ endpoints and deal with _HTTP_ requests and responses
  * `Repository` classes interface with the _database_ and take care of writing and reading data to/from persistent storage
  * `Client` classes talk to other APIs, in our case it fetches _JSON_ via _HTTP_ from the openweathermap.org weather API


  ```
  Request  ┌────────── Spring Service ───────────┐
   ─────────→ ┌─────────────┐    ┌─────────────┐ │   ┌─────────────┐
   ←───────── │  Controller │ ←→ │  Repository │←──→ │  Database   │
  Response │  └─────────────┘    └─────────────┘ │   └─────────────┘
           │         ↓                           │
           │    ┌──────────┐                     │
           │    │  Client  │                     │
           │    └──────────┘                     │
           └─────────│───────────────────────────┘
                     │
                     ↓   
                ┌──────────┐
                │    ☁     │
                │ Weather  │
                │   API    │
                └──────────┘
  ```  
    
 #  Integration Test  
    
    ```
     ╭┄┄┄┄┄┄┄╮      ┌──────────┐      ┌──────────┐
     ┆   ☁   ┆  ←→  │    ☕     │  ←→  │    💾     │
     ┆  Web  ┆      │  Spring  │      │ Database │
     ╰┄┄┄┄┄┄┄╯      │  Service │      └──────────┘
                    └──────────┘
    
      │    Controller     │      Repository      │
      └─── Integration ───┴──── Integration ─────┘
    
      │                                          │
      └────────────── Acceptance ────────────────┘               
    ```
    
    ```
     ┌─────────┐  ─┐
     │    ☁    │   │
     │ Strip   │   │
     │   API   │   │
     │  Stub   │   │
     └─────────┘   │ Client
          ↑        │ Integration
          ↓        │ Test
     ┌──────────┐  │
     │    ☕     │  │
     │  Spring  │  │
     │  Service │  │
     └──────────┘ ─┘
    ```


## Tools
You can find lots of different tools, frameworks and libraries being used in the different examples:

  * **Spring Boot**: application framework
  * **JUnit**: test runner
  * **Hamcrest Matchers**: assertions
  * **Mockito**: test doubles (mocks, stubs)
  * **MockMVC**: testing Spring MVC controllers
  * **RestAssured**: testing the service end to end via HTTP
  * **Wiremock**: provide HTTP stubs for downstream services