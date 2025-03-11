#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /app
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app/target/spring-0.0.1-SNAPSHOT.jar"]
COPY ./target/spring-0.0.1-SNAPSHOT.jar /app
CMD ["java", "-jar", "spring-0.0.1-SNAPSHOT.jar"]