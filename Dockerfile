# use an official OpenJDK image from the Docker Hub
FROM amazoncorretto:21
# set the working directory inside of the container
WORKDIR /app
# Copy the built JAR file from the target directory to the working directory in the container
COPY target/ccs-tech-movie-0.0.1-SNAPSHOT.jar app.jar
# Expose the port that the application will run on
EXPOSE 8080
# Command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]