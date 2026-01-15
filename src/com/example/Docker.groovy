package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImg(String imageName) {
        script.echo 'building the docker image...'
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            // sh 'docker build -t 0yorkzhang0/demo-app:jma-2.0 .'
            script.sh "docker build -t $imageName ."
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER} --password-stdin'"
            script.sh "docker push $imageName"
        }
    }
}
