FROM amazoncorretto:17.0.7-alpine
ADD applications/app-service/build/libs/*.jar app-service-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app-service-0.0.1.jar"]