pipeline {
    agent {
         label 'slave1'
    }
    environment {
        course = "kubernetes"
        name= "swarna"
        cloud = "azure"
    }
    stages {
        stage('Build') {
            environment {
                cloud = "GCP"
            }
            steps {
                //${env.variable}
                //${params.variable}
                echo "building the aplicationa"
                echo "welcome ${name} enrolled ${course}"
                echo "you are certified in1 ${cloud}"
            }
        }
        stage ('SecondStage'){
            steps {
                echo " welcome to ${name}"
                echo " you are certified in1 ${cloud}"
            }
        }
    }
}