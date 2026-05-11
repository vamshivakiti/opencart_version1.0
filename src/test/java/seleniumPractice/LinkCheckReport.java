package seleniumPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to generate reports from link check results
 */
public class LinkCheckReport {
	
	private List<LinkCheckResult> results;
	private long totalCheckTime;
	
	public LinkCheckReport() {
		this.results = new ArrayList<>();
	}
	
	public void addResult(LinkCheckResult result) {
		results.add(result);
	}
	
	public void setTotalCheckTime(long totalCheckTime) {
		this.totalCheckTime = totalCheckTime;
	}
	
	public int getTotalLinksChecked() {
		return results.size();
	}
	
	public int getBrokenLinksCount() {
		return (int) results.stream().filter(r -> "BROKEN".equals(r.getStatus())).count();
	}
	
	public int getValidLinksCount() {
		return (int) results.stream().filter(r -> "VALID".equals(r.getStatus())).count();
	}
	
	public int getErrorLinksCount() {
		return (int) results.stream().filter(r -> "ERROR".equals(r.getStatus())).count();
	}
	
	public int getSkippedLinksCount() {
		return (int) results.stream().filter(r -> "SKIPPED".equals(r.getStatus())).count();
	}
	
	public List<LinkCheckResult> getBrokenLinks() {
		return results.stream().filter(r -> "BROKEN".equals(r.getStatus())).toList();
	}
	
	public void printReport() {
		System.out.println("\n" + "=".repeat(70));
		System.out.println("BROKEN LINKS ANALYSIS REPORT");
		System.out.println("=".repeat(70));
		System.out.println("Total Links Checked: " + getTotalLinksChecked());
		System.out.println("Valid Links: " + getValidLinksCount());
		System.out.println("Broken Links: " + getBrokenLinksCount());
		System.out.println("Error Links: " + getErrorLinksCount());
		System.out.println("Skipped Links: " + getSkippedLinksCount());
		System.out.println("Total Check Time: " + totalCheckTime + " ms");
		System.out.println("=".repeat(70));
		
		if (getBrokenLinksCount() > 0) {
			System.out.println("\nBROKEN LINKS DETAILS:");
			getBrokenLinks().forEach(link -> System.out.println(link));
		}
		System.out.println("=".repeat(70));
	}
}
