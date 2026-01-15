package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImg(String imageName) {
        script.echo 'building the docker image...'
        script.withCredentials([script.usernamePassword(
                credentialsId: 'docker-hub-repo',
                usernameVariable: 'DOCKER_USER',
                passwordVariable: 'DOCKER_PASS'
        )]) {
            script.sh """
                docker build -t ${imageName} .
                echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
                docker push ${imageName}
            """
        }
    }
}