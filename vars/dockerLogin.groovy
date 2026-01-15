#!/user/bin/env groovy

import com.example.Docker

def call(String imageName) {
//    echo 'building the docker image...'
//    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//        // sh 'docker build -t 0yorkzhang0/demo-app:jma-2.0 .'
//        sh "docker build -t $imageName ."
//        sh 'echo $PASS | docker login -u $USER --password-stdin'
//        sh "docker push $imageName"
    return new Docker(this).dockerLogin()
}
