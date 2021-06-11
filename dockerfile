FROM openjdk:11-jre-slim
RUN mkdir /app
COPY target/mq-spring-boot-demo.jar app/mq-spring-boot-demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app/mq-spring-boot-demo.jar"]