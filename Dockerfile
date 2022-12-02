FROM maven:3.8.6-jdk-8-slim as builder
COPY src/main/java src/main/java
COPY pom.xml pom.xml
RUN mvn clean package

FROM openjdk:8-jre-alpine
COPY --from=builder /target/Translator-jar-with-dependencies.jar Translator.jar
ENTRYPOINT ["java", "-jar", "Translator.jar"]
