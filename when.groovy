pipeline {
    agent {
        label 'slave1'
    }
    environment {
        DEPLOY_TO = 'production'
    }
    stages{
        stage('prod'){
            when {
                environment name: 'DEPLOY_TO', value: 'production'
            }
            steps {
                echo "deploy to prod"
            }
        }
    }
}