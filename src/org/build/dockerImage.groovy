package org.build

public void buildImageKaniko(String contextDir, String dockerfile, String destination, String tag=""){
    try{
        echo "Build with Kaniko..."
        println("The full image name(+ registry): ${destination}:${tag}${BUILD_NUMBER}")
        
        sh"""
            /kaniko/executor --context ${contextDir} --dockerfile ${contextDir}/${dockerfile} \
                                                     --destination=${destination}:${tag}${BUILD_NUMBER}
        """
    } catch(err){
        echo 'Exception occurred: ' + err.toString()
        currentBuild.result = 'FAILURE'
    }
}