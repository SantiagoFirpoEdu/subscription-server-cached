FROM amazoncorretto:21-alpine

WORKDIR app

RUN apk add --no-cache maven

LABEL authors="Grupo Fort"

COPY . .

RUN mvn clean package spring-boot:repackage

RUN chmod +x target/subscription_server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","target/subscription_server-0.0.1-SNAPSHOT.jar"]
