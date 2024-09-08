FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/Coinbase_Crypto-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar", "app.jar"]
EXPOSE 8080
