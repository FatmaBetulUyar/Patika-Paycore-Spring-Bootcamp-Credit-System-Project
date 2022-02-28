FROM openjdk:8-jdk-alpine

MAINTAINER Fatma BEtül UYAR <fbluyar2@gmail.com>
EXPOSE 8085
ADD target/creditsystem-0.0.1-SNAPSHOT.jar creditsystem.jar

ENTRYPOINT ["java","-jar","creditsystem.jar"]


# Create Dockerfile
# Build executable jar file - mvn clean package
# Build Docker image     - 
docker build -t airport-reservation-app:v1 .
# Run Docker container using the image built -   
docker run --name airport-reservation-system -p 8080:8080 airport-reservation-applicaiton:v1