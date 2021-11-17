pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'ls -la && cd GoSecuriApp && mvn --version && mvn clean && mvn package && mvn install'
      }
    }

    stage('Run') {
      steps {
        sh 'ls -la && cd GoSecuriApp && java -jar target/GoSecuriApp-1.0-SNAPSHOT.jar && ls -la'

      }
    }

    stage('Deploy') {
      agent {
        docker {
          image 'gosecuri:latest'
        }
      }
      steps {
        sh 'cat /etc/nginx/conf.d/default.conf'
      }
    }

  }
  tools {
    maven 'Maven'
    nodejs 'NodeJS'
  }
}
