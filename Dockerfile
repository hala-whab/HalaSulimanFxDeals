FROM openjdk:26-oraclelinux8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} HalaSulimanFxDealsApp.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/HalaSulimanFxDealsApp.jar"]