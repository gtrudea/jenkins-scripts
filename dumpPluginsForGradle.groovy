// TODO: output jenkisn dependencies, add any special cases
println Jenkins.instance.getVersion()

def plugins = Jenkins.instance.pluginManager.plugins.toSorted()

plugins.each{
  plugin ->
  def attrs = plugin.getManifest().mainAttributes
//  println "${plugin.getInfo().name},${plugin.getVersion()}, ${attrs.getValue('Group-Id')}"
  println "compile group: \'${attrs.getValue('Group-Id')}\', name: \'${plugin.getInfo().name}\', version: \'${plugin.getVersion()}\', ext: 'jar'"
  println ""
}