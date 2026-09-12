#Use JDK 21 as base image. Using eclipse-temurin here
FROM eclipse-temurin:21-jdk-alpine

#Set the working directory in the container
WORKDIR /app

#Copy application files to the container (Hello.java)   
COPY Hello.java /app  

#Compile the Java program (Hello.java) to generate the Hello.class file
RUN javac Hello.java

#Command to run the Java program
CMD ["java", "Hello"]