FROM amazoncorretto:11.0.10-alpine
RUN mkdir /app
COPY target/*.jar /app/test.jar
CMD ["java","-jar","/app/test.jar"]
RUN apk --update add fontconfig ttf-dejavu