FROM java:8
MAINTAINER Rick Broker<rbroker@digital.ai>

COPY *.war app.war

EXPOSE 8080/tcp

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.war"]
