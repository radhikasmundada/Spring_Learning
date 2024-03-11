FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/bajajmall-app.jar .
EXPOSE 8080
CMD ["java","-jar","bajajmall-app.jar"]
