FROM java:8
VOLUME /accdoctor-fellow
COPY target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 7000
