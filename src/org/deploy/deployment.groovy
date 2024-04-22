package org.deploy

public void create(String labName, String deploymentName, String fullImageName, String credentialsId){
    try{
        echo "Deploy deployment at ${labName}"
        println("Deplyment ${deploymentName}: image_name(${fullImageName})")
        withCredentials([string(credentialsId: "${credentialsId}", variable: 'token')]) {
            sh"""
                kubectl create deployment ${deploymentName} --image=${fullImageName} --token ${token} -n ${labName}
            """
        }
    } catch(err){
        echo 'Exception occurred: ' + err.toString()
        currentBuild.result = 'FAILURE'
    }
}