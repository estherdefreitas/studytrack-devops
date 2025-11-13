# Stage 1: build
FROM gradle:9.2.0-jdk21-alpine AS build
WORKDIR /app
COPY src src
COPY build.gradle.kts .
COPY settings.gradle.kts .
RUN gradle clean bootJar --no-daemon

# Stage 2: runtime
FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
COPY secrets/db_secrets secrets/db_secrets
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh
EXPOSE 8080
ENTRYPOINT ["/entrypoint.sh"]