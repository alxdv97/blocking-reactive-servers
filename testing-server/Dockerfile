FROM maven:3.6.3-openjdk-11 AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:11

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/testing-server-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "testing-server-0.0.1-SNAPSHOT.jar"]
