pipeline {
    agent any
    environment {
        PATH = "${env.PATH};C:\\Windows\\System32" // Update the PATH to include the directory of cmd.exe
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'FarToCel', url: 'https://github.com/kassu11/opt1-java.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('compile') {
            steps {
                bat 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                success {
                    // Publish JUnit test results
                    junit '**/target/surefire-reports/TEST-*.xml'
                    // Generate JaCoCo code coverage report
                    jacoco(execPattern: '**/target/jacoco.exec')
                }
            }
        }
        stage('verify') {
            steps {
                bat 'mvn verify'
            }
        }
        stage('Deploy') {
            steps {
                bat 'mvn deploy'
            }
        }
    }
}
