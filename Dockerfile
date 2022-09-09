FROM maven:3.8.6-amazoncorretto-8
RUN yum update -y && yum install shadow-utils.x86_64 -y
RUN mkdir 777 /app && chmod 777 /app && cd /app
WORKDIR /app
RUN groupadd ctcgrp && useradd ctcusr -G ctcgrp
USER ctcusr:ctcgrp
COPY ./pom.xml ./mvnw ./
COPY ./src ./src
RUN mvn clean package -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/target/apprunner-0.0.1-SNAPSHOT.jar"]
