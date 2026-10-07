pipeline {

    agent any

    triggers {
        cron('H 2 * * 1-5')   // around 2 AM, Monday to Friday
    }

    tools {
        jdk 'JDK-21'
        maven 'Maven-3.9.6'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Environment Check') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
                bat 'docker --version'
                bat 'docker compose version'
            }
        }

        stage('Start Selenium Grid') {
            steps {
                bat 'docker compose up -d'
            }
        }

        stage('Check Selenium Grid') {
            steps {
                bat 'docker compose ps'
            }
        }

        stage('Clean Allure Results') {
            steps {
                bat 'if exist allure-results rmdir /s /q allure-results'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {

            allure([
                results: [
                    [path: 'allure-results']
                ]
            ])

            script {
                bat(
                    returnStatus: true,
                    script: 'docker compose down'
                )
            }
        }
    }
}