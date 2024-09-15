#FROM ubuntu
#RUN apt-get update && apt-get install -y tzdata
#RUN apt-get -y install apache2
#ADD index.html /var/www/html/
#ENTRYPOINT ["apachectl", ".D", "FOREGROUND"]
#ENV name coinbasecrypto
FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./target/backend-app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8085
