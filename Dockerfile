FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./target/backend-app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8085
