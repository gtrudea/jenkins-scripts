import net.bull.javamelody.*;
import net.bull.javamelody.internal.model.*;
import net.bull.javamelody.internal.common.*;
 
java = new JavaInformations(Parameters.getServletContext(), true);
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