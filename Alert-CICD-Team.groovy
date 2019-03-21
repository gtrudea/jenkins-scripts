@Library('jenkins-reference-framework@master')
//import com.mrll.javelin.model.slack.MessageType
import com.mrll.javelin.alert.SlackAlert
import com.mrll.javelin.alert.AlertFactory

def slackAlert = AlertFactory.create(SlackAlert, [channel: params.room, customMessage: params.messagetext, messageType: params.messagetypes])

pipeline {
//

    agent any
    
    stages{
        stage('build') {
            steps{
                script{
                    sh 'printenv'
                }
            }
        }
        stage('notify') {
            steps{
                script{
                    withCredentials([string(credentialsId: 'new-mrll-svc-slack', variable: 'slack_token')]) {
                    try {
                        slackAlert.send(env, currentBuild)
                    } 
                    catch(all) {
                        echo "Slack send failed!!!! ${messageType} : ${repoNotifyRooms} : ${message}"
                        throw all
                    }
                    }
                }
            }
        }
    }
}
