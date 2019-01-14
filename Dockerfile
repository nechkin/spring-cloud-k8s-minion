FROM openjdk:8-jdk-alpine
ENV PORT 8080
EXPOSE 8080
ARG JAR_FILE
COPY ${JAR_FILE} /opt/app.jar
WORKDIR /opt
CMD ["java", "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "app.jar"]
