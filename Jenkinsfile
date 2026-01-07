pipeline {
    agent {
        label 'java-slave'
    }
    stages {
        stage ("maven app"){
            steps {
                echo "** building maven application"
            }
            stage ('Codeanalys'){
                steps {
                    echo "running sonar scan"
                }
            }
            stage("dockerbuildpush") {
                steps {
                    echo "****buldi and push docker images"
                }
            }
            stage ("deploytostage"){
                steps {
                    echo "deploy to dev"
                }
            }
            stage ("deploytoprod"){
                steps {
                    echo "deploy to prod"
                    input{
                        message "doing prod deployment"
                        ok "yes"
                        submitter "abc"
                    }
                }
            }
        }
    }
}
