pipeline {
    agent any

    tools {
        jdk 'JDK11'  // Ajusta a la versión de Java que uses
        gradle 'Gradle_8'  // Ajusta a la versión de Gradle configurada en Jenkins
    }

    environment {
        // Puedes definir variables de entorno aquí, por ejemplo, la URL de GitHub o tokens
        GITHUB_CREDENTIALS_ID = 'Escorcia' // Configura el ID de tus credenciales de GitHub en Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout desde GitHub
                git branch: 'main', url: 'https://github.com/jorgeescorcia/RestfulBookerAPI_TEvolvers.git', credentialsId: "${env.GITHUB_CREDENTIALS_ID}"
            }
        }

        stage('Compile') {
            steps {
                // Compilar el proyecto
                sh 'gradle clean compileJava'
            }
        }

        stage('Test') {
            steps {
                // Ejecutar las pruebas de Serenity BDD
                sh 'gradle clean test aggregate'
            }
        }

        stage('Report') {
            steps {
                // Publicar los reportes de Serenity BDD si es necesario
                publishHTML(target: [
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Serenity BDD Report'
                ])
            }
        }
    }

    post {
        always {
            // Limpia después de ejecutar el pipeline
            cleanWs()
        }
        success {
            echo 'Pipeline completado exitosamente!'
        }
        failure {
            echo 'Hubo un fallo en el pipeline.'
        }
    }
}
