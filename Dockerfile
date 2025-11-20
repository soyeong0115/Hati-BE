# Build stage
FROM gradle:8.14.3-jdk17 AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY gradlew gradlew.bat ./
COPY gradle ./gradle
COPY src ./src
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

# Run stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENV PORT=8080
CMD ["sh", "-c", "java -jar -Dserver.port=$PORT app.jar"]