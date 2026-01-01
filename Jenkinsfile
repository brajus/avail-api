pipeline {
    agent any
    tools{
        maven 'maven_3_9_11'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/brajus/RBS/tree/main/rbs-avail-api']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t baluraju224/rbs-avail-api .'
                }
            }
        }
    }
}