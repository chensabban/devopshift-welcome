pipeline {
    agent any // Run on any available agent
    stages {
        stage('Clone') {
            steps {
                git {
                remote { url('https://github.com/yanivomc/devopshift-welcome.git') }
                branches('elbit/jenkinsdec26') // this is fine
                scriptPath('students/Terkel/080124/jobs/my-pipeline.groovy')
                extensions { }  // required as otherwise it may try to tag the repo, which you may not want
                }
                git 'https://github.com/yanivomc/devopshift-welcome.git' // Replace with your repository URL
            }
        }

        stage('Build') {
            steps {
                sh 'echo javac' 
            }
        }

        stage('Parallel Tests') {
            parallel {
                stage('Unit test') {
                    steps {
                        sh 'echo “unit test”'
                    }
                }
                stage('ntegration test') {
                    steps {
                        sh 'echo “unit test”' 
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo 'Pipeline completed success.'
        }
        failure {
            mail bcc: '', body: 'my pipe done fail', cc: '', from: '', replyTo: '', subject: 'my pipe', to: 'terkmail@gmail.com'
        }
    }
}