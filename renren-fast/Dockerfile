FROM java:8
VOLUME /accdoctor-admin
COPY target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 6000