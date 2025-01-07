
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/accounts.jar accountApp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "accountApp.jar"]
