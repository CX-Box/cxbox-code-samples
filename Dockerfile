FROM eclipse-temurin:17-jdk
COPY target/cxbox-code-samples-exec.jar /app/cxbox-code-samples.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "cxbox-code-samples.jar"]