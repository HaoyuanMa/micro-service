FROM java:8
VOLUME /accdoctor-user
COPY target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 9000