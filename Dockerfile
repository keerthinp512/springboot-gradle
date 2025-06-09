FROM openjdk:21
LABEL authors="223068845"
WORKDIR /app
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]