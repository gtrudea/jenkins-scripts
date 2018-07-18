println Jenkins.instance.getVersion()

def plugins = Jenkins.instance.pluginManager.plugins.toSorted()

plugins.each{
  plugin ->
  	println "${plugin.getInfo().name},${plugin.getVersion()},${plugin.info.version}"
}