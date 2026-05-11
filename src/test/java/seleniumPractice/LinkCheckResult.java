package seleniumPractice;

/**
 * Model class to store individual link check results
 */
public class LinkCheckResult {
	
	private String url;
	private int statusCode;
	private String status; // VALID, BROKEN, ERROR, SKIPPED
	private String errorMessage;
	private long checkTime;
	
	public LinkCheckResult(String url, int statusCode, String status) {
		this.url = url;
		this.statusCode = statusCode;
		this.status = status;
	}
	
	public LinkCheckResult(String url, String status, String errorMessage) {
		this.url = url;
		this.status = status;
		this.errorMessage = errorMessage;
		this.statusCode = -1;
	}
	
	// Getters and Setters
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public long getCheckTime() {
		return checkTime;
	}
	
	public void setCheckTime(long checkTime) {
		this.checkTime = checkTime;
	}
	
	@Override
	public String toString() {
		return "[" + status + "] " + url + " - Status Code: " + statusCode + 
				(errorMessage != null ? " - Error: " + errorMessage : "");
	}
}
