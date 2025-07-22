pipeline {
    agent any

    tools {
        maven 'MyMaven'  
        jdk 'MyJava'       
    }

    environment {
        REPORT_DIR = "target"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/PoojaGowrisetty/RosemountTankMasterAT.git', branch: 'master'
            }
        }

        stage('Build and Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Publish Cucumber HTML Report') {
            steps {
                cucumber buildStatus: 'UNSTABLE',
                    fileIncludePattern: '**/cucumber.json',
                    jsonReportDirectory: "${REPORT_DIR}"
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*.html', fingerprint: true
            junit 'target/surefire-reports/*.xml'
        }
    }
}
