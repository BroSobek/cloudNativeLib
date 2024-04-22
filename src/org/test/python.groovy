package org.test

public void unitest(String unitestScript){
    try{
        echo "Unitest for python repository..."
        
        sh"python3 ${unitestScript}"
    } catch(err){
        echo 'Exception occurred: ' + err.toString()
        currentBuild.result = 'FAILURE'
    }
}