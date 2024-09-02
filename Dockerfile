FROM amazoncorretto:17-alpine3.14

WORKDIR /app

COPY target/mcsv-property-0.0.1-SNAPSHOT.jar /app
COPY ./pom.xml /app
COPY mvnw /app
COPY ./.mvn /app/.mvn
COPY ./src /root/src

CMD ["java", "-jar", "mcsv-property-0.0.1-SNAPSHOT.jar"]