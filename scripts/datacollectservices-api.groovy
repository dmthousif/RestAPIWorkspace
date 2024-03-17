dir('module') {
	withMaven(mavenLocalRepo: '.repository', jdk: JDK_VERSION, maven: MAVEN_INST, options: [junitPublisher(disabled: true)]) {
		script {
			dir("automation/datacollectservices-api") {

				try {
					sh("pwd")
					sh("ls -an")
					sh "mvn clean verify -Denvironment=default"
				}
					
					catch(err) {
					echo "Caught: ${err}"
					currentBuild.result = "FAILURE"
				} finally {
					sh "mvn serenity:aggregate"
					zip zipFile: 'TestResults.zip', archive: false, dir: 'target/site/serenity'
					archiveArtifacts artifacts: 'TestResults.zip', fingerprint: true
					publishHTML(target: [
						reportName : 'Test Automation Results',
						reportDir:   'target/site/serenity',
						reportFiles: 'index.html',
						keepAll:     true,
						alwaysLinkToLastBuild: true,
						allowMissing: false
					])
				}
			}
		}
	}
}
