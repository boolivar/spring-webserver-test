Minimal example to test Spring Boot reactive Tomcat

```
./gradlew bR

...

***************************
APPLICATION FAILED TO START
***************************
```

Process alive after faliure report.

Workarounds:
1. Spring Boot 3.1.12
1. switch to servlet using `spring-boot-starter-web` dependendency