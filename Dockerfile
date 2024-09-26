# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Install necessary packages and SDKMAN
RUN apt-get update && apt-get install -y curl zip unzip && \
    curl -s "https://get.sdkman.io" | bash && \
    bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install gradle"

# Make SDKMAN and Gradle available in the current shell session
ENV SDKMAN_DIR="/root/.sdkman" \
    PATH="/root/.sdkman/candidates/gradle/current/bin:$PATH"

# Set the working directory in the container
WORKDIR /app

# Copy the project files to the container
COPY . .

# Expose port 8080
EXPOSE 8080

# Command to compile and run the application with continuous recompilation
CMD ["gradle", "bootRun", "--continuous"]
