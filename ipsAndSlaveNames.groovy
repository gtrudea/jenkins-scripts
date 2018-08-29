import hudson.model.Computer.ListPossibleNames

Jenkins.instance.getComputers().eachWithIndex{ it, index ->
  if (it.getChannel()) {
      def ips = it.getChannel().call(new ListPossibleNames())
    remoteIps = ips.findAll { ip -> !(ip ==~ /^172\..*/)}
    remoteIps.each { ip -> println "${ip}   ${it.name}" }
                                    
  }
}