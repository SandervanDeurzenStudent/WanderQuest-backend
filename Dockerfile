FROM eclipse-temurin:21
RUN mkdir /opt/app
ENV PORT 8080
EXPOSE 8080
COPY build/libs/test.jar /opt/app
CMD ["java", "-jar", "/opt/app/wanderquest.jar"]
