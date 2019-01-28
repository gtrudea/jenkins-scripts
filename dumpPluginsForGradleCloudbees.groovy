def returnList = []
returnList << Jenkins.instance.getVersion()

def plugins = Jenkins.instance.pluginManager.plugins.toSorted()

plugins.each{
  plugin ->
  def attrs = plugin.getManifest().mainAttributes
  returnList << "compile group: \'${attrs.getValue('Group-Id')}\', name: \'${attrs.getValue('Short-Name')}\', version: \'${attrs.getValue('Plugin-Version')}\', ext: 'jar'"
}
return returnList.join('\n').toString()