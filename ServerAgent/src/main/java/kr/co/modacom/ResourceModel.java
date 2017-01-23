package kr.co.modacom;

/**
 * 
 * @author byeon
 * 
 */
public class ResourceModel {

	private String serverId;

	private int cpuUsage;
	private int cpuPeak;

	// private double memoryTotalSize;
	private int memoryPeak;
	private int memoryUsage;

	private double diskUsage;
	private double diskTotalSize;

	private int serverState;
	private String regiDate;

	private String host;
	private int port;

	public ResourceModel() {
		this.cpuUsage = 0;
		this.cpuPeak = 0;
		// this.memoryTotalSize = 0;
		this.memoryPeak = 0;
		this.memoryUsage = 0;
		this.diskUsage = 0;
		this.diskTotalSize = 0;
		this.serverState = 0;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public int getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(int cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public int getCpuPeak() {
		return cpuPeak;
	}

	public void setCpuPeak(int cpuPeak) {
		this.cpuPeak = cpuPeak;
	}

	public int getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(int memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	public int getMemoryPeak() {
		return memoryPeak;
	}

	public void setMemoryPeak(int memoryPeak) {
		this.memoryPeak = memoryPeak;
	}

	public double getDiskUsage() {
		return diskUsage;
	}

	public void setDiskUsage(double diskUsage) {
		this.diskUsage = diskUsage;
	}

	public double getDiskTotalSize() {
		return diskTotalSize;
	}

	public void setDiskTotalSize(double diskTotalSize) {
		this.diskTotalSize = diskTotalSize;
	}

	public int getServerState() {
		return serverState;
	}

	public void setServerState(int serverState) {
		this.serverState = serverState;
	}

	public String getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}

}
