node ('master'){
env.PATH = "${tool 'Maven3'}/bin:${env.PATH}"

  checkout scm
  sh 'mvn clean install'
  }