pipeline {
    agent {
        label 'slave1'
    }
    stages {
        stage ('Build'){
            steps {
                echo "building the applicaiton"
            }
        }
        stage('Scans'){
          steps {
            echo "performing the scans"
          }
        }
        stage ('DeploytoDev'){
            steps {
                echo "deploy to dev"
            }
        }
          stage ('DeploytoTest'){
            steps {
                echo "deploy to Test"
            }
        }
          stage ('DeploytoStage'){
            when {
                expression {
                    BRANCH_NAME ==~ /(production|staging)/
                }
            }
            steps {
                echo "deploy to stage"
            }
        }
          stage ('Deploytoprod'){
             when {
                expression {
                    BRANCH_NAME ==~ /(production|staging)/
                }
            }
            steps {
                echo "deploy to prod"
            }
        }
    }
}