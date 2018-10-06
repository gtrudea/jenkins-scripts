import net.bull.javamelody.*;
import net.bull.javamelody.internal.model.*;
import net.bull.javamelody.internal.common.*;
 
String nodeName = null; // null for all nodes, not null for a particular node
Map mapByNodeName = new RemoteCallHelper(nodeName).collectJavaInformationsListByName();
for (node in mapByNodeName.keySet()) {
  java = mapByNodeName.get(node);
  println "\nNode:\n    " + node;
 
  println "\nsessions count:\n    " + java.sessionCount;
  println "\nactive HTTP threads count:\n    " + java.activeThreadCount;
  println "\nthreads count:\n    " + java.threadCount;
  println "\nsystem load average:\n    " + java.systemLoadAverage;
  println "\nsystem cpu load:\n    " + java.systemCpuLoad; // since 1.59
  println "\navailable processors:\n    " + java.availableProcessors;
  println "\nhost:\n    " + java.host;
  println "\nos:\n    " + java.os;
  println "\njava version:\n    " + java.javaVersion;
  println "\njvm version:\n    " + java.jvmVersion;
  println "\npid:\n    " + java.pid;
  println "\nserver info:\n    " + java.serverInfo;
  println "\ncontext path:\n    " + java.contextPath;
  println "\nstart date:\n    " + java.startDate;
  println "";
 
  memory = java.memoryInformations;
  println "\nused memory:\n    " + Math.round(memory.usedMemory / 1024 / 1024) + " Mb";
  println "\nmax memory:\n    " + Math.round(memory.maxMemory / 1024 / 1024) + " Mb";
  println "\nused perm gen:\n    " + Math.round(memory.usedPermGen / 1024 / 1024) + " Mb";
  println "\nmax perm gen:\n    " + Math.round(memory.maxPermGen / 1024 / 1024) + " Mb";
  println "\nused non heap:\n    " +       Math.round(memory.usedNonHeapMemory / 1024 / 1024) + " Mb";
  println "\nused physical memory:\n    " +       Math.round(memory.usedPhysicalMemorySize / 1024 / 1024) + " Mb";
  println "\nused swap space:\n    " +       Math.round(memory.usedSwapSpaceSize / 1024 / 1024) + " Mb";
  println "";
 
  threads = java.getThreadInformationsList();
  deadlocked = new java.util.ArrayList();
  for (thread in threads) {
    if (thread.deadlocked)
      deadlocked.add(thread);
  }
  println deadlocked.size() + " deadlocked threads / " + threads.size() + " threads (" + java.activeThreadCount + " threads active)";
  for (thread in deadlocked) {
    println "";
    println thread;
    for (s in thread.getStackTrace())
      println "    " + s;
  }
  println "";
 
  println "*************************************************************";
  println "";
}