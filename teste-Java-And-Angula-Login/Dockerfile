# Estágio 1: Build (Compilação)
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY . .
# Se usar Maven: RUN ./mvnw clean package -DskipTests
# Se usar Gradle: RUN ./gradlew clean build -x test
RUN ./gradlew clean build -x test

# Estágio 2: Run (Execução)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copia o .jar gerado no estágio anterior
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]