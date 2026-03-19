pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk21'
    }

    parameters {
        choice(
            name: 'MODULE',
            choices: [
                'web',
                'client-api-test'
            ],
            description: 'Выберите модуль, в котором нужно запустить тесты'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run tests') {
            steps {
                sh "mvn clean test -pl ${params.MODULE} -am"
            }
        }

        stage('Allure report') {
            steps {
                allure includeProperties: false,
                       jdk: '',
                       results: [[path: "${params.MODULE}/target/allure-results"]]
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: "${params.MODULE}/target/surefire-reports/*.xml"
        }
    }
}