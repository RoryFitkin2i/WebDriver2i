pipeline{
  agent any
  tools {
    maven 'Maven'
  }
  stages{
    stage("build"){
          
          steps{
            echo 'building the application...'
            bat "mvn -B compile"
          }
     }
    stage("test"){
          
          steps{
              bat 'mvn -B clean install'
              cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
              }
      }
      stage('Archive'){
          steps{
              archiveArtifacts 'target/*.jar'
          }
      }
   }
}
          
          
