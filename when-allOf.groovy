pipeline {
    agent {
        label 'slave1'
    }
    environment {
        DEPLOY_TO = 'production'
    }
    stages{
        stage("DeployToDev")        
        {
            steps {
                   echo "deploy to dev env"
            } 
        }
        stage('prod'){
            when {
                allOf {
                    branch "production"
                    environment name: 'DEPLOY_TO', value: 'production'
                }
            }
            steps {
                echo "deploy to prod"
            }
        }
    }
}