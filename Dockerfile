FROM openjdk:21
EXPOSE 8090
WORKDIR /app
COPY target/marketplace-1.0.0-SNAPSHOT.jar /app/marketplace.jar
ENTRYPOINT ["java", "-jar", "marketplace.jar"]