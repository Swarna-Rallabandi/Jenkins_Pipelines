pipeline {
    agent {
        label "slave1"
    }
    parameters {
        string (
            name: 'PERSON',
            defaultValue: 'swarna',
            description: 'what is my name'
        )
        choice (
            name: 'CHOICE',
            choices: ['oone', 'two', 'threee'],
            description : 'pic some number'
        )
        booleanParam(
            name: 'TOGLE',
            defaultValue: true,
            description: 'toogkle this '

        )
        text(
            name: 'RELEASE',
            defaultValue: '',
            description : 'enter some details'

        )
    }
    stages {
        stage ('param') {
            steps {
                echo "hellow ${params.PERSON}"
                echo "relase ${params.RELEASE}"
                echo " ${params.TOGLE}"
                echo " ${params.CHOICE}"
            }

        }
    }
}