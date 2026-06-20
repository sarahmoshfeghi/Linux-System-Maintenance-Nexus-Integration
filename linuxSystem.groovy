pipeline {
    agent any

    parameters {
        choice(
            name: 'MAINTENANCE_TASK', 
            choices: ['all', 'repos', 'kernel', 'nexus'], 
            description: 'Select scope of patching/tooling updates to run.'
        )
    }

    stages {
        stage('Lint Check') {
            steps {
                sh "ansible-playbook -i inventory.ini site.yml --syntax-check"
            }
        }
        stage('Execute') {
            steps {
                script {
                    if (params.MAINTENANCE_TASK == 'all') {
                        sh "ansible-playbook -i inventory.ini site.yml"
                    } else {
                        sh "ansible-playbook -i inventory.ini site.yml --tags ${params.MAINTENANCE_TASK}"
                    }
                }
            }
        }
    }
}
