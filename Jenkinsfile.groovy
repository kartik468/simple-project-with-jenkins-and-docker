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

    post {
        always {
            echo 'This will always run'
            echo 'I will always say Hello again!'
            
            emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}
