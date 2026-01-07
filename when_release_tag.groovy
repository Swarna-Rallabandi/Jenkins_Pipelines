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
                anyOf {
             branch 'release/*'
             tag pattern: "v\\d{1,2}.\\d{1.2}.\\d{1,2}", comparator: 'REGEXP'
                }
               
            }
            steps {
                echo "deploy to stage"
            }
        }
          stage ('Deploytoprod'){
             when {
                expression {
                    //v1.2.
                    tag pattern: "v\\d{1,2}.\\d{1.2}.\\d{1,2}", comparator: 'REGEXP'
                }
            }
            steps {
                echo "deploy to prod"
            }
        }
    }
}