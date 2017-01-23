package kr.co.modacom;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Timer;

import org.apache.log4j.Logger;

/**
 * 
 * @author byeon
 * 
 */
public class App {

	final static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		ScheduleTask task = new ScheduleTask();
		Timer timer = new Timer();
		long callTime = 0;
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = App.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);

			task.setAmsServerHost(prop.getProperty("ams.server.address"));
			task.setAmsServerPort(Integer.parseInt(prop.getProperty("ams.server.port")));
			task.setSourceServerHost(prop.getProperty("source.server.address"));
			task.setSourceServerPort(Integer.parseInt(prop.getProperty("source.server.port")));
			task.setThreadSleepTime(Long.parseLong(prop.getProperty("repeat.time")));
			callTime = Long.parseLong(prop.getProperty("call.time"));

			logger.info("setting properties..");
			logger.info("======================================");
			logger.info("AmsServerHost : " + task.getAmsServerHost());
			logger.info("AmsServerPort : " + task.getAmsServerPort());
			logger.info("SourceServerHost : " + task.getSourceServerHost());
			logger.info("SourceServerPort : " + task.getSourceServerPort());
			logger.info("repeatTime : " + task.getThreadSleepTime() + " second");
			logger.info("callTime : " + callTime + " second");
			logger.info("======================================");

		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}

		callTime = callTime * 1000;
		logger.info("start agent...");
		timer.scheduleAtFixedRate(task, callTime, callTime);
		task.runTask();
	}
}
