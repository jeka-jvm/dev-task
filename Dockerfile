FROM openjdk:11
MAINTAINER Evgenii
COPY /target/developer-task-0.0.1-SNAPSHOT.jar /home/developer-task-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/developer-task-0.0.1-SNAPSHOT.jar"]