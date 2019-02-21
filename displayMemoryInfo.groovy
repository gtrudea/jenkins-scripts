import net.bull.javamelody.*;
import net.bull.javamelody.internal.model.*;
import net.bull.javamelody.internal.common.*;
 
memory = new MemoryInformations();
println "\nused memory:\n    " + Math.round(memory.usedMemory / 1024 / 1024) + " Mb";
println "\nmax memory:\n    " + Math.round(memory.maxMemory / 1024 / 1024) + " Mb";
println "\nused perm gen:\n    " + Math.round(memory.usedPermGen / 1024 / 1024) + " Mb";
println "\nmax perm gen:\n    " + Math.round(memory.maxPermGen / 1024 / 1024) + " Mb";
println "\nused non heap:\n    " +       Math.round(memory.usedNonHeapMemory / 1024 / 1024) + " Mb";
println "\nused physical memory:\n    " +       Math.round(memory.usedPhysicalMemorySize / 1024 / 1024) + " Mb";
println "\nused swap space:\n    " +       Math.round(memory.usedSwapSpaceSize / 1024 / 1024) + " Mb";