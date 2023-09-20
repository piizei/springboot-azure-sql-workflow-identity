FROM openjdk:17.0.2-jdk-slim as builder

WORKDIR /app

COPY gradle gradle/
COPY *.gradle gradlew ./
RUN CHMOD u+x gradlew
RUN ./gradlew --help > /dev/null

COPY src src/

RUN ./gradlew clean build -x test
RUN mkdir /app/extracted && \
    java -Djarmode=layertools -jar /app/build/libs/mssql-0.0.1-SNAPSHOT.jar extract --destination /app/extracted

FROM gcr.io/distroless/java17-debian11:nonroot

EXPOSE 8080
WORKDIR /app

COPY --from=builder /app/extracted/dependencies /app/
COPY --from=builder /app/extracted/spring-boot-loader /app/
COPY --from=builder /app/extracted/snapshot-dependencies /app/
COPY --from=builder /app/extracted/application /app/

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]