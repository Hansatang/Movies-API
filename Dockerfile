FROM gradle:7.6 AS build
WORKDIR /home/gradle/movies-api/
RUN chown gradle:gradle .
USER gradle
COPY --chown=gradle:gradle build.gradle settings.gradle ./
COPY --chown=gradle:gradle ./src/ ./src/
RUN gradle --no-daemon bootJar

FROM eclipse-temurin:17-jre-alpine
COPY --from=build /home/gradle/movies-api/build/libs/movies-service.jar /opt/movies/
ENTRYPOINT ["java", "-jar", "/opt/movies/movies-service.jar"]
