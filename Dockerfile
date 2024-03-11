FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/bajajmall.jar .
EXPOSE 8080
CMD ["java","-jar","bajajmall.jar"]
