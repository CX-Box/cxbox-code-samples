package core.config.junit;

import com.sun.management.OperatingSystemMXBean;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

@Slf4j
public class JvmStatsConfig implements BeforeEachCallback, AfterEachCallback {

	public static String logJvmPerf() {
		// Get the OperatingSystemMXBean instance for OS memory and CPU details
		OperatingSystemMXBean osBean = (OperatingSystemMXBean) java.lang.management.ManagementFactory.getOperatingSystemMXBean();

		// Get total physical memory from the OS in GB
		var totalOSMemory = osBean.getTotalPhysicalMemorySize() / (1024 * 1024 * 1024); // GB
		var freeOSMemory = osBean.getFreePhysicalMemorySize() / (1024 * 1024 * 1024); // GB
		var ramUsagePercentOS = ((double) (totalOSMemory - freeOSMemory) / totalOSMemory) * 100;

		// Get total and free memory in the JVM
		var runtime = Runtime.getRuntime();
		var totalJVMMemory = (runtime.totalMemory()) / (1024 * 1024); // JVM heap memory in MB
		var freeJVMMemory = (runtime.freeMemory()) / (1024 * 1024); // Free JVM memory in MB
		var ramUsagePercentJVM = ((double) (totalJVMMemory - freeJVMMemory) / totalJVMMemory) * 100;

		// Get CPU usage for the system
		var cpuUsagePercent = osBean.getSystemCpuLoad() * 100; // CPU load in percentage

		// Create a single log message with RAM and CPU usage first, then others
		return String.format(
				"JVM RAM Usage: %.2f%%, OS RAM Usage: %.2f%%, CPU Usage: %.2f%%, " +
						"JVM Total RAM: %d MB, JVM Free RAM: %d MB, " +
						"OS Total RAM: %d GB, OS Free RAM: %d GB",
				ramUsagePercentJVM, ramUsagePercentOS, cpuUsagePercent,
				totalJVMMemory, freeJVMMemory, totalOSMemory, freeOSMemory
		);
	}

	@Override
	public void beforeEach(ExtensionContext context) {
		//skip
	}

	@Override
	@SneakyThrows
	public void afterEach(ExtensionContext context) {
		try {
			String logMessage = logJvmPerf() + " after test " + context.getUniqueId();
			// Log everything in one message
			log.info(logMessage);
		} catch (Exception exception) {
			log.error("Cannot log JVM stats: ", exception);
		}
	}

}
