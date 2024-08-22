# Używamy obrazu bazowego JDK
FROM eclipse-temurin
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.gijar"]