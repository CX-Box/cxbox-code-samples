FROM openjdk:8
ADD target/cxbox-code-samples-exec.jar /app/cxbox-code-samples.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "cxbox-code-samples.jar"]