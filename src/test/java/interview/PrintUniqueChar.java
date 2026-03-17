package interview;

import java.util.LinkedHashSet;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintUniqueChar {

	public static void main(String[] args) {
		//String data = new TextFileReader().readDataFromFIle("textFile");
		WebDriver driver = new ChromeDriver();
		//driver.get(data);
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Print any string");
		String input =sc.nextLine();
		LinkedHashSet<Character> uniqueCHar = new LinkedHashSet<Character>();
		for(char c : input.toCharArray()) {
			uniqueCHar.add(c);
		}
System.out.println("Print Unique char");
for(char c : uniqueCHar) {
	System.out.print(c);
}
	}

}
