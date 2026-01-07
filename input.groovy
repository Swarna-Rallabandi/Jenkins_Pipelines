pipeline {
    agebt {
        label 'java-slave'
    }
    stages {
        stage {
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
                }
            }
        }
    }
}