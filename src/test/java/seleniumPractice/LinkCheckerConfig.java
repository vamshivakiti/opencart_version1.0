package seleniumPractice;

/**
 * Configuration class for LinkChecker
 * Makes the code more scalable and configurable
 */
public class LinkCheckerConfig {
	
	private int connectionTimeout;
	private int readTimeout;
	private int threadPoolSize;
	private int responseCodeThreshold;
	
	public LinkCheckerConfig() {
		this.connectionTimeout = 5000;
		this.readTimeout = 5000;
		this.threadPoolSize = 5;
		this.responseCodeThreshold = 400;
	}
	
	public LinkCheckerConfig(int connectionTimeout, int readTimeout, int threadPoolSize, int responseCodeThreshold) {
		this.connectionTimeout = connectionTimeout;
		this.readTimeout = readTimeout;
		this.threadPoolSize = threadPoolSize;
		this.responseCodeThreshold = responseCodeThreshold;
	}
	
	// Getters and Setters
	public int getConnectionTimeout() {
		return connectionTimeout;
	}
	
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}
	
	public int getReadTimeout() {
		return readTimeout;
	}
	
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}
	
	public int getThreadPoolSize() {
		return threadPoolSize;
	}
	
	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}
	
	public int getResponseCodeThreshold() {
		return responseCodeThreshold;
	}
	
	public void setResponseCodeThreshold(int responseCodeThreshold) {
		this.responseCodeThreshold = responseCodeThreshold;
	}
}
