package seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
	private static final int CONNECTION_TIMEOUT = 5000;
	private static final int READ_TIMEOUT = 5000;
	private static final int THREAD_POOL_SIZE = 5;
	
	private AtomicInteger brokenLinksCount = new AtomicInteger(0);
	private AtomicInteger validLinksCount = new AtomicInteger(0);
	private AtomicInteger skippedLinksCount = new AtomicInteger(0);
	
	/**
	 * Main method to check broken links on a given URL
	 */
	public static void main(String[] args) {
		String websiteUrl = "https://testautomationpractice.blogspot.com/";
		BrokenLinks linkChecker = new BrokenLinks();
		linkChecker.checkBrokenLinks(websiteUrl);
	}
	
	/**
	 * Check broken links on a website using Selenium
	 * @param websiteUrl - URL of the website to check
	 */
	public void checkBrokenLinks(String websiteUrl) {
		WebDriver driver = null;
		try {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(websiteUrl);
			
			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			System.out.println("Total links found: " + allLinks.size());
			
			// Extract href values
			List<String> urls = extractUrls(allLinks);
			
			// Check links with thread pool for better performance
			checkLinksWithThreadPool(urls);
			
			// Print summary report
			printSummaryReport();
			
		} catch (Exception e) {
			System.err.println("Error during link checking: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}
	
	/**
	 * Extract valid URLs from WebElements
	 */
	private List<String> extractUrls(List<WebElement> allLinks) {
		List<String> urls = new ArrayList<>();
		for (WebElement link : allLinks) {
			String href = link.getAttribute("href");
			if (href != null && !href.isEmpty() && href.startsWith("http")) {
				urls.add(href);
			}
		}
		return urls;
	}
	
	/**
	 * Check links using thread pool for concurrent processing
	 */
	private void checkLinksWithThreadPool(List<String> urls) {
		ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		
		for (String url : urls) {
			executor.execute(() -> checkLinkValidity(url));
		}
		
		executor.shutdown();
		while (!executor.isTerminated()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
	}
	
	/**
	 * Check if a single URL is broken or valid
	 */
	private void checkLinkValidity(String urlString) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("HEAD");
			connection.setConnectTimeout(CONNECTION_TIMEOUT);
			connection.setReadTimeout(READ_TIMEOUT);
			connection.setInstanceFollowRedirects(true);
			
			int responseCode = connection.getResponseCode();
			
			if (responseCode >= 400) {
				System.out.println("[BROKEN] " + urlString + " - Status: " + responseCode);
				brokenLinksCount.incrementAndGet();
			} else {
				System.out.println("[VALID] " + urlString + " - Status: " + responseCode);
				validLinksCount.incrementAndGet();
			}
			
			connection.disconnect();
			
		} catch (IOException e) {
			System.out.println("[ERROR] " + urlString + " - " + e.getMessage());
			brokenLinksCount.incrementAndGet();
		} catch (Exception e) {
			System.err.println("[EXCEPTION] " + urlString + " - " + e.getMessage());
			skippedLinksCount.incrementAndGet();
		}
	}
	
	/**
	 * Print summary report
	 */
	private void printSummaryReport() {
		System.out.println("\n" + "=".repeat(50));
		System.out.println("BROKEN LINKS REPORT");
		System.out.println("=".repeat(50));
		System.out.println("Total Valid Links: " + validLinksCount.get());
		System.out.println("Total Broken Links: " + brokenLinksCount.get());
		System.out.println("Total Skipped Links: " + skippedLinksCount.get());
		System.out.println("Total Links Checked: " + (validLinksCount.get() + brokenLinksCount.get()));
		System.out.println("=".repeat(50));
	}
}
