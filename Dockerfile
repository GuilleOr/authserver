FROM java:8
MAINTAINER seebogado@gmail.com
EXPOSE 9999
ADD target/authserver-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'
ADD wait-for-it.sh /wait-for-it.sh
RUN bash -c 'chmod 777 /wait-for-it.sh'
CMD ["java","-Dspring.profiles.active=docker","-jar","/app.jar"]
