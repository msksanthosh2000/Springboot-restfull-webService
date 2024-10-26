FROM eclipse-temurin:22

COPY target/Springboot-restfull-webService-0.0.1-SNAPSHOT.jar /app/springboot-usermanagement.jar

ENTRYPOINT ["java", "-jar", "/app/springboot-usermanagement.jar"]