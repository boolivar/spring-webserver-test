Minimal example to test Spring Boot reactive Tomcat for spring-projects/spring-boot#44101

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
1. [ApplicationListener](https://github.com/boolivar/spring-webserver-test/commit/213f2d2ff305f028e46ca6d9a7206771490b3968)
