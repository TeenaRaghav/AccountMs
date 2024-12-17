
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/AccountMS-0.0.1-SNAPSHOT.jar accountApp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "accountApp.jar"]
