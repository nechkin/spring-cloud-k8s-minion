FROM openjdk:8-jdk-alpine
ENV PORT 8080
EXPOSE 8080
ARG JAR_FILE
COPY ${JAR_FILE} /opt/app.jar
WORKDIR /opt
CMD ["java", "-jar", "app.jar"]
