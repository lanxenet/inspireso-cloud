FROM inspireso/java:8-jre-alpine
VOLUME /tmp
ADD app /app
RUN sh -c 'touch /app.jar'
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/bootstrap.jar"]