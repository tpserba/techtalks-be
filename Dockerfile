FROM openjdk:17-jdk-slim
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/techtalks-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} techtalkbe.jar
ENTRYPOINT ["java","-jar","techtalkbe.jar"]