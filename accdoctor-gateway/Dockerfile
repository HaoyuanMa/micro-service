FROM java:8
VOLUME /accdoctor-gateway
COPY target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 88