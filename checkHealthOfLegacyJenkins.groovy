URLlist = ["jenkins.devtools.merrillcorp.com","jaasnode.devtools.merrillcorp.com","jaasdwrks.devtools.merrillcorp.com","jaasufo.devtools.merrillcorp.com","jaastops.devtools.merrillcorp.com","jaasrdc.devtools.merrillcorp.com","jaasqa.devtools.merrillcorp.com","jaasappsupport.devtools.merrillcorp.com","devtools.merrillcorp.com","cloudbees-core.dsitei.com","cloudbees-core.edgetools.merrillcorp.com"]
failedList = "\n"
successList = "\n"
for (theUrl in URLlist){
    def URL = ("http://" + theUrl).toURL()
    try{
       def content = URL.getText()
	   //println "success for " + URL
       successList = successList + theUrl + "\n"
    }
    catch (Exception e) {
       //println "failure: " + e
       failedList = failedList + e.toString() + "\n" 
    }
}
println ("the following urls were successful: " + successList)
println ("the following urls failed: " + failedList)
if (failedList != "\n"){
    build job: 'slack-send', propagate: false, parameters: [[$class: 'StringParameterValue', name: 'room', value: 'CICDJ_ALERT'], [$class: 'StringParameterValue', name: 'messagetypes', value: 'NOTIFICATION'], [$class: 'StringParameterValue', name: 'messagetext', value: 'One or more Jenkins masters have failed an http check']]
    throw new MyException("Url checks failed") 
} 

class MyException extends Exception{
   String str1;
   /* Constructor of custom exception class
    * here I am copying the message that we are passing while
    * throwing the exception to a string and then displaying 
    * that string along with the message.
    */
   MyException(String str2) {
	str1=str2;
   }
   public String toString(){ 
	return ("MyException Occurred: "+str1) ;
   }
}
