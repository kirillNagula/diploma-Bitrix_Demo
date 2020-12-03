FROM openjdk:14
COPY target/*.jar config-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","config-0.0.1-SNAPSHOT.jar"]