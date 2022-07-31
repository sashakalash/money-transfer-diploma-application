FROM openjdk:18-jdk-alpine
EXPOSE 5500
ADD target/money-transfer-0.0.1-SNAPSHOT.jar money-transfer.jar
ENTRYPOINT ["java","-jar","/money-transfer.jar"]