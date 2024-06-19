FROM amazoncorretto:21-alpine
# get maven from https://maven.apache.org/download.cgi
RUN apk add --no-cache maven

#tag the image
LABEL authors="Grupo Fort"

# build with maven
COPY pom.xml .
RUN mvn clean package spring-boot:repackage

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
