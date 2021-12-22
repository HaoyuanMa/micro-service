FROM java:8
VOLUME /accdoctor-order
COPY target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8000