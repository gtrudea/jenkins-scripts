import hudson.util.RemotingDiagnostics;

script = 'def proc = "ls -1a /home/jenkins/jenkins_slave/workspace | wc -l".execute(); proc.waitFor(); println proc.in.text';

for (slave in Jenkins.instance.slaves) {
println slave.name;
try {
println RemotingDiagnostics.executeGroovy(script, slave.getChannel());
} catch (all) {
all.printStackTrace();
}
}