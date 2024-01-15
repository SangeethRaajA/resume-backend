FROM maven:maven:3.8.7-openjdk-18 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM maven:3.8.7-openjdk-18-slim
COPY --from=build /target/simple-resume-0.0.1-SNAPSHOT.jar simple-resume.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
