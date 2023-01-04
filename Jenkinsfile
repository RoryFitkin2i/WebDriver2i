pipeline{
  agent any
  tools {
    maven 'Maven'
    jdk 'JDK'
  }
  stages{
    stage("build"){
          
          steps{
            echo 'building the application...'
            sh "mvn install"
          }
     }
    stage("test"){
          
          steps{
            echo 'testing the application...'
          }
     }
    stage("deploy"){
          
          steps{
            echo 'deploying the application...'
          }
     }
   }
}
          
          
