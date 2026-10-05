pipeline {

    agent any
triggers {
        cron('H 2 * * 1-5')   // around 2 AM, Monday to Friday
    }
    tools {
        jdk 'JDK-21'
        maven 'Maven-3.9.16'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Start Selenium Grid') {
            steps {
                bat '"C:\\Users\\knx-admin-user\\AppData\\Local\\Programs\\DockerDesktop\\resources\\cli-plugins\\docker-compose.exe" up -d'
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
                results: [[path: 'allure-results']]
            ])

            bat '"C:\\Users\\knx-admin-user\\AppData\\Local\\Programs\\DockerDesktop\\resources\\cli-plugins\\docker-compose.exe" down'
        }
    }
}