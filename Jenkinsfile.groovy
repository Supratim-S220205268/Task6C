pipeline{
    
    agent any
    
    stages{
        
        stage('Build') {
            steps {
                echo "Building the code using a build automation tool to compile and package the code."
                echo "Tool Used: Apache Ant"
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo "Running the unit tests to ensure the code functions as expected and running integration tests to ensure the different components of the application work together as expected."
                echo "Tool Used: Selenium"
            }
             post {
                success{
                    mail to: "natusvincere45@gmail.com",
                    subject: "Unit and Integration Test Alert",
                    body: "Status: The Unit and Integration Testing is completed successfully."
                    
                }
                failure{
                    mail to: "natusvincere45@gmail.com",
                    subject: "Unit and Integration Test Alert",
                    body: "Status: The Unit and Integration Testing has failed."
                }
            }
        }
        stage('Code Analysis') {
            steps {
                echo "Integrating code analysis tool to analyse the code and ensure it meets industry standards."
                echo "Tool Used: SonarQube"
            }
        }
        stage('Security Scan') {
            steps {
                echo "Performing a security scan on the code using a tool to identify any vulnerabilities."
                echo "Tool Used: Nessus"
            }
            post {
                success{
                    mail to: "natusvincere45@gmail.com",
                    subject: "Security Scan Alert",
                    body: "Status: The Security Scan has been completed successfully"
                }
                failure{
                    mail to: "natusvincere45@gmail.com",
                    subject: "Security Scan Alert",
                    body: "Status: The Security Scan has failed."
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo "Deploying the application to a staging server"
                echo "Tool Used: Bamboo"
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo "Running integration tests on the staging environment to ensure the application functions as expected in a production-like environment."
                echo "Tool Used: Citrus"
            }
            post {
                success{
                    mail to: "natusvincere45@gmail.com",
                    subject: "Staging - Integration Test Alert",
                    body: "Status: The Integration Testing on Staging environment is completed successfully."
                    
                }
                failure{
                    mail to: "natusvincere45@gmail.com",
                    subject: "Staging - Integration Test Alert",
                    body: "Status: The Integration Testing on Staging environment has failed."
                }
            }
        }
        stage('Deploy to Production') {
            steps {
                echo "Deploying the application to a production server"
                echo "Tool Used: CircleCI"
            }
        }
        
        
    }
}
