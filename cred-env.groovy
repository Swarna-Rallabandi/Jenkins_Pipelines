pipeline {
    agent {
        label 'slave1'
    }
    environment {
        course = "kubernetes"
        GITHUB_CREDS= credentials('swarna-ssh-creds')
        SONAR_CREDS=credentials('sonar_token')
        SONAR_URL:'http:----'
    }
    stages {
        stage('Build'){
            steps {
                echo "my github credentials are ${GITHUB_CREDS}"
                echo "username ${GITHUB_CREDS_USR}"
                echo "password ${GITHUB_CREDS_PSW}"
            }

        }
        stage ('sonar'){
            steps {
                sh """
                mvn sonar:sonar \
                -Dsonar.host.url=${SONAR_URL}
                -Dsonar.login=${SONAR_CREDS}
                """
            }
        }
    }
}