FROM maven:3.8.2-jdk-11-slim as build
WORKDIR /build

COPY pom.xml .
COPY src src

RUN mvn package

FROM amazoncorretto:11.0.12
ARG DEPENDENCY=/build/src/presentation/api/target
COPY --from=build ${DEPENDENCY}/api-1.0.0.jar /app/

CMD [ "java", "-jar", "/app/api-1.0.0.jar" ]