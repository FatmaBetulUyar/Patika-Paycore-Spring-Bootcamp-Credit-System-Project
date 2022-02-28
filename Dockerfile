FROM openjdk:8-jdk-alpine

MAINTAINER Fatma BEtül UYAR <fbluyar2@gmail.com>
EXPOSE 8085
ADD target/creditsystem-0.0.1-SNAPSHOT.jar creditsystem.jar

ENTRYPOINT ["java","-jar","creditsystem.jar"]