package seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Improved BrokenLinks class with better scalability and configuration
 * Features:
 * - Configurable timeout and thread pool settings
 * - Better error handling
 * - Thread-safe operations
 * - Detailed reporting
 * - Reusable for different websites
 */
public class BrokenLinksImproved {
	
	private LinkCheckerConfig config;
	private LinkCheckReport report;
	private AtomicInteger processedLinks;
	
	/**
	 * Constructor with default configuration
	 */
	public BrokenLinksImproved() {
		this.config = new LinkCheckerConfig();
		this.report = new LinkCheckReport();
		this.processedLinks = new AtomicInteger(0);
	}
	
	/**
	 * Constructor with custom configuration
	 */
	public BrokenLinksImproved(LinkCheckerConfig config) {
		this.config = config;
		this.report = new LinkCheckReport();
		this.processedLinks = new AtomicInteger(0);
	}
	
	/**
	 * Main method to check broken links
	 */
	public static void main(String[] args) {
		String websiteUrl = "https://testautomationpractice.blogspot.com/";
		
		// Using default configuration
		BrokenLinksImproved linkChecker = new BrokenLinksImproved();
		linkChecker.checkBrokenLinks(websiteUrl);
		
		// Alternatively, use custom configuration:
		// LinkCheckerConfig customConfig = new LinkCheckerConfig(10000, 10000, 10, 400);
		// BrokenLinksImproved linkChecker = new BrokenLinksImproved(customConfig);
		// linkChecker.checkBrokenLinks(websiteUrl);
	}
	
	/**
	 * Check broken links on a website using Selenium
	 * @param websiteUrl - URL of the website to check
	 */
	public LinkCheckReport checkBrokenLinks(String websiteUrl) {
		WebDriver driver = null;
		long startTime = System.currentTimeMillis();
		
		try {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(websiteUrl);
			
			// Wait for page to load
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			System.out.println("Total links found: " + allLinks.size());
			
			// Extract valid URLs
			List<String> validUrls = extractValidUrls(allLinks);
			System.out.println("Valid URLs to check: " + validUrls.size());
			
			// Check links with thread pool
			checkLinksWithThreadPool(validUrls);
			
			// Calculate total time
			long endTime = System.currentTimeMillis();
			report.setTotalCheckTime(endTime - startTime);
			
			// Print detailed report
			report.printReport();
			
		} catch (Exception e) {
			System.err.println("Error during link checking: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
		
		return report;
	}
	
	/**
	 * Extract valid URLs from WebElements with proper filtering
	 */
	private List<String> extractValidUrls(List<WebElement> allLinks) {
		List<String> validUrls = new ArrayList<>();
		
		for (WebElement link : allLinks) {
			String href = link.getAttribute("href");
			
			// Filter: href must not be null, empty, or empty string
			if (href != null && !href.isEmpty() && isValidUrl(href)) {
				validUrls.add(href);
			}
		}
		
		return validUrls;
	}
	
	/**
	 * Validate URL format
	 */
	private boolean isValidUrl(String urlString) {
		return urlString.startsWith("http://") || urlString.startsWith("https://");
	}
	
	/**
	 * Check links using thread pool for concurrent processing
	 */
	private void checkLinksWithThreadPool(List<String> urls) {
		ExecutorService executor = Executors.newFixedThreadPool(config.getThreadPoolSize());
		
		for (String url : urls) {
			executor.execute(() -> {
				checkLinkValidity(url);
				processedLinks.incrementAndGet();
				System.out.println("Progress: " + processedLinks.get() + "/" + urls.size());
			});
		}
		
		executor.shutdown();
		
		// Wait for all tasks to complete
		try {
			if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
				executor.shutdownNow();
				System.err.println("Thread pool did not terminate within 5 minutes");
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
			Thread.currentThread().interrupt();
			System.err.println("Thread pool interrupted: " + e.getMessage());
		}
	}
	
	/**
	 * Check if a single URL is broken or valid
	 */
	private synchronized void checkLinkValidity(String urlString) {
		HttpURLConnection connection = null;
		
		try {
			URL url = new URL(urlString);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("HEAD");
			connection.setConnectTimeout(config.getConnectionTimeout());
			connection.setReadTimeout(config.getReadTimeout());
			connection.setInstanceFollowRedirects(true);
			
			// Add user agent to avoid blocking
			connection.setRequestProperty("User-Agent", "Mozilla/5.0");
			
			int responseCode = connection.getResponseCode();
			LinkCheckResult result;
			
			if (responseCode >= config.getResponseCodeThreshold()) {
				result = new LinkCheckResult(urlString, responseCode, "BROKEN");
				System.out.println("[BROKEN] " + urlString + " - Status: " + responseCode);
			} else {
				result = new LinkCheckResult(urlString, responseCode, "VALID");
				System.out.println("[VALID] " + urlString + " - Status: " + responseCode);
			}
			
			report.addResult(result);
			
		} catch (IOException e) {
			LinkCheckResult result = new LinkCheckResult(urlString, "ERROR", e.getMessage());
			report.addResult(result);
			System.out.println("[ERROR] " + urlString + " - " + e.getMessage());
		} catch (Exception e) {
			LinkCheckResult result = new LinkCheckResult(urlString, "SKIPPED", e.getMessage());
			report.addResult(result);
			System.err.println("[EXCEPTION] " + urlString + " - " + e.getMessage());
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	
	/**
	 * Get the report from checking
	 */
	public LinkCheckReport getReport() {
		return report;
	}
}
