pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/keerthinp512/springboot-gradle.git'
            }
        }

        stage('Build with Gradle') {
            steps {
                // Give permission and run the Gradle build
                sh 'chmod +x ./gradlew'
                sh './gradlew build'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t gradle-project .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d -p 8081:8080 --name gradle-project gradle-project'
            }
        }
    }
}
