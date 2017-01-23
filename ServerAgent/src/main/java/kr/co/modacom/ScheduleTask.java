package kr.co.modacom;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import com.sun.management.OperatingSystemMXBean;

/**
 * 
 * @author byeon
 * 
 */
public class ScheduleTask extends TimerTask {

	final static Logger logger = Logger.getLogger(ScheduleTask.class);

	private String sourceServerHost;
	private int sourceServerPort;
	private String amsServerHost;
	private int amsServerPort;
	private OperatingSystemMXBean osBean;
	private long threadSleepTime;
	private ResourcePicker picker;
	private ResourceModel model;
	private int count;

	public ScheduleTask() {
		this.count = 0;
		osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	}

	public long getThreadSleepTime() {
		return threadSleepTime;
	}

	public void setThreadSleepTime(long threadSleepTime) {
		this.threadSleepTime = threadSleepTime;
	}

	public String getAmsServerHost() {
		return amsServerHost;
	}

	public void setAmsServerHost(String amsServerHost) {
		this.amsServerHost = amsServerHost;
	}

	public int getAmsServerPort() {
		return amsServerPort;
	}

	public void setAmsServerPort(int amsServerPort) {
		this.amsServerPort = amsServerPort;
	}

	public String getSourceServerHost() {
		return sourceServerHost;
	}

	public void setSourceServerHost(String sourceServerHost) {
		this.sourceServerHost = sourceServerHost;
	}

	public int getSourceServerPort() {
		return sourceServerPort;
	}

	public void setSourceServerPort(int sourceServerPort) {
		this.sourceServerPort = sourceServerPort;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		logger.info("run task...");
		File file = new File("/");
		long totalSpace = file.getTotalSpace();
		int sourceServerState = isLiveServer(getSourceServerHost(), getSourceServerPort());
		String url = "http://" + getAmsServerHost() + ":" + getAmsServerPort() + "/admin/agent/system/resource";

		model.setServerId(getHostName());
		model.setCpuUsage(model.getCpuUsage() / getCount());
		model.setMemoryUsage(model.getMemoryUsage());
		model.setDiskTotalSize(totalSpace);
		model.setDiskUsage(totalSpace - file.getUsableSpace());
		model.setServerState(sourceServerState);
		model.setHost(getSourceServerHost());
		model.setPort(getSourceServerPort());

		logger.info("======================================");
		logger.info("ServerId : " + getHostName());
		logger.info("CpuUsage : " + model.getCpuUsage() / getCount() + "%");
		logger.info("CpuPeak : " + model.getCpuPeak() + "%");
		logger.info("MemoryUsage : " + model.getMemoryUsage() + "%");
		logger.info("MemoryPeak : " + model.getMemoryPeak() + "%");
		logger.info("MemoryTotalSize : " + osBean.getTotalPhysicalMemorySize());
		logger.info("DiskTotalSize : " + totalSpace);
		logger.info("DiskUsage : " + (totalSpace - file.getUsableSpace()));
		logger.info("ServerState : " + sourceServerState);
		logger.info("======================================");

		if (isLiveServer(getAmsServerHost(), getAmsServerPort()) == 1) {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.put(url, model);
			logger.info("call url : " + url);
		} else {
			logger.info("Not connected to AMS Server...( " + url + " )");
		}
		setCount(0);
		model = new ResourceModel();
	}

	public void runTask() {
		picker = new ResourcePicker();
		model = new ResourceModel();

		while (true) {
			miningSystemResource(picker, model, osBean);
		}
	}

	public void miningSystemResource(ResourcePicker picker, ResourceModel model, OperatingSystemMXBean osBean) {
		int newCpu = picker.getCpu(osBean);
		int newMemory = picker.getMemory(osBean);

		if (newCpu > 0) {
			if (newCpu > model.getCpuPeak())
				model.setCpuPeak(newCpu);

			if (newMemory > model.getMemoryPeak())
				model.setMemoryPeak(newMemory);

			// sum
			model.setCpuUsage(newCpu + model.getCpuUsage());
			model.setMemoryUsage(newMemory);
		}

		try {
			Thread.sleep(getThreadSleepTime() * 1000);
		} catch (InterruptedException ex) {
			logger.error(ex.getMessage());
		}

		setCount(getCount() + 1);
	}

	public int isLiveServer(String host, int port) {
		Socket socket = null;
		try {
			socket = new Socket(host, port);
			if (socket.isConnected())
				return 1; // running.
		} catch (IOException ex) {
			logger.error(ex.getMessage() + " target : http://" + host + ":" + port);
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException ex) {
					logger.error(ex.getMessage());
				}
			}
		}
		return 0; // stop.
	}

	public String getHostName() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException ex) {
			logger.error(ex.getMessage());
		}

		return null;
	}
}
