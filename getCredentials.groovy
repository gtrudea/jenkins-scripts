/**
Author: kuisathaverat
Description: List ID and Description of all credentials on a Jenkins Instance.
**/
import com.cloudbees.plugins.credentials.Credentials

Set<Credentials> allCredentials = new HashSet<Credentials>();

def creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
      com.cloudbees.plugins.credentials.Credentials.class
);

allCredentials.addAll(creds)

Jenkins.instance.getAllItems(com.cloudbees.hudson.plugins.folder.Folder.class).each{ f ->
 creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
      com.cloudbees.plugins.credentials.Credentials.class, f)
  allCredentials.addAll(creds)
  
}

for (c in allCredentials) {
	def out = new StringBuffer()
	def pw = c.hasProperty('password') ? c.password : 'no pw'
  	def user = c.hasProperty('username') ? c.username : 'no username'
	def secret = c.hasProperty('secret') ? c.secret : 'no secret'
  	def scope = c.hasProperty('scope') ? c.scope : 'scope'
//  	println c.metaClass.methods*.name.sort().unique()
  	def id = c.id.padRight(22)
  	out << id
  	out << " | "
  	out << user.padLeft(18)
  	out << " : "
  	out << pw.toString().padRight(34)
  	out << " "
	out << "(${secret.toString()})"
	out << " -- "
  	out << c.description
  	out << " "
    out << c.scope
//   	println(id + " -- " + c.description + " | " + user + " : " + pw)
  	println out.toString()
}