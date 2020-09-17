pipeline {
    agent any

    stages {
        // stage('Testing Environment') {
        //     steps {
        //         dir("server/") {
        //             sh 'mvn test -Dtest=ControllerAndServiceSuite'
        //             sh 'mvn test -Dtest=IntegrationSuite'
        //         }
        //     }
        // }
        stage('Build') {
            steps {
                dir("server/"){
                    sh 'mvn install -DskipTests'
                }
            }
        }
        stage('Staging') {
            steps {
                sh 'docker-compose build'
                sh 'docker-compose up -d'
            }
        }
        // stage('end2end Tests') {
        //     steps {
        //         dir("server/") {
        //             sh 'mvn test -Dtest=SeleniumSuite'
        //         }
        //     }
        // }
    }
}
