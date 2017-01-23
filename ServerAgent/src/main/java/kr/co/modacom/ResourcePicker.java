package kr.co.modacom;

import com.sun.management.OperatingSystemMXBean;

/**
 * 
 * @author byeon
 * 
 */
public class ResourcePicker {

	public int getCpu(OperatingSystemMXBean osBean) {
		return (int) (osBean.getSystemCpuLoad() * 100.0);
	}

	public int getMemory(OperatingSystemMXBean osBean) {
		return (int) (((1 - osBean.getFreePhysicalMemorySize() * 1.0 / osBean.getTotalPhysicalMemorySize()) * 100.0));
	}
}
