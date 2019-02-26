import hudson.model.Computer.ListPossibleNames

// this expands on script ipsAndSlaveNames.groovy by also pulling a list of labels,
// and by displaying a slightly more human-readable format.
for (_slave in hudson.model.Hudson.instance.slaves) {
    println("Node: ${_slave.name}")

    // test the node for up/down and, if up, pull the IP addresses
    def computer = _slave.computer
    if (computer.online) {
        println("Labels: ${_slave.getLabelString()}")
        println("IP Addresses:\n----------")
        def ips = jenkins.model.Jenkins.instance.getNode(_slave.name).getChannel().call(new ListPossibleNames())
        remoteIps = ips.findAll { ip -> !(ip ==~ /^172\..*/)}
        remoteIps.each { ip -> println "${ip}"}
    } else {
        println("Unable to retrieve device information")
    }
    println("\n")
}