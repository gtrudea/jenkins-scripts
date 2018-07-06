import jenkins.branch.BranchEventCause

Jenkins.instance.getAllItems(Job).each{

  def jobBuilds=it.getBuilds()

	//for each of such jobs we can get all the builds (or you can limit the number at your convenience)
    jobBuilds.each { build ->
      if (build.toString().contains("angular2-seed2/develop")) {
        build.getChangeSets().each { it.each { changeset -> println changeset.getAuthor() } }
        def runningSince = groovy.time.TimeCategory.minus( new Date(), build.getTime() )
        def currentStatus = build.buildStatusSummary.message
        def cause = build.getCauses()[0] //we keep the first cause
        //This is a simple case where we want to get information on the cause if the build was 
        //triggered by an user
        def user = cause instanceof Cause.UserIdCause? cause.getUserId():""
        def branchCause = cause.getShortDescription()
        //This is an easy way to show the information on screen but can be changed at convenience
        println "Build: ${build} | Since: ${runningSince} | Status: ${currentStatus} | Cause: ${cause} | User: ${user}"
        println "Branch: ${branchCause}"
       
        // You can get all the information available for build parameters.
        def parameters = build.getAction(ParametersAction)?.parameters
        parameters.each {
          println "Type: ${it.class} Name: ${it.name}, Value: ${it.dump()}" 
        
          }
      }
    }
}