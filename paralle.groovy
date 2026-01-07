pipeline{
    agent {
        label 'slave1'
    }
    stages {
        stage ('build'){
            steps {
                echo "building the application"
                }
            
        }
        stage('parellscans'){
          parallel {
            stage ('sonar'){
                steps {
                    echo "sonar stage is executing"
                    sleep 10
                }
            }
             stage ('Fortify'){
                steps {
                    echo "fortify stage is executing"
                    sleep 10
                }
            }
             stage ('prisma'){
                steps {
                    echo "prisma stage is executing"
                    sleep 10
                }
            }
          }
        }

    }
}