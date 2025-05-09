# Use OpenJDK 17 base image (non-alpine for ARM64 compatibility)
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy project jar file
COPY target/orderprocessor-0.0.1-SNAPSHOT.jar app.jar

# Expose port (if needed)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
