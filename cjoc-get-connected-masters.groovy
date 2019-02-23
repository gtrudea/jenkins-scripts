import com.cloudbees.opscenter.server.model.OperationsCenter

// https://support.cloudbees.com/hc/en-us/articles/225498787-How-to-programmatically-connect-a-Client-Master-to-CJOC-

OperationsCenter.instance.getConnectedMasters().each {
    println "${it.name}"
    println " id: ${it.id}"
    println " idName: ${it.idName}"
    println " grantId: ${it.grantId}"
}