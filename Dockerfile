FROM openjdk:17
COPY target/cxbox-code-samples-exec.jar /app/cxbox-code-samples.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "cxbox-code-samples.jar","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"]