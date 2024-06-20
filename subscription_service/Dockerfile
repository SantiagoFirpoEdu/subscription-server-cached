FROM amazoncorretto:21-alpine

WORKDIR app

RUN apk add --no-cache maven

LABEL authors="Grupo Fort"

COPY . .

RUN mvn clean package spring-boot:repackage

ENTRYPOINT ["java","-jar","target/subscription_service-0.0.1-SNAPSHOT.jar"]
