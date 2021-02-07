FROM openjdk:11
ENV APPJAR=user-management.0.0.1-SNAPSHOT.jar

COPY build/resources/main/db/migration/* /flyway/sql/
COPY build/libs/${APPJAR}