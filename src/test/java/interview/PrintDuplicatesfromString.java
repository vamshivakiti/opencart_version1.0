package interview;

import java.time.Duration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.internal.util.BlockingIgnoringReceiver;

public class PrintDuplicatesfromString {

	public static void main(String[] args) {
		String s = "programming";
//		char words[]=s.toCharArray();
//		
//		Set<Character> set = new HashSet<>();
//		for(char word:words) {
//			if(set.add(word)) {
//				System.out.print(word);		
//			}
		
//		}
		//WebDriver driver = new ChromeDriver();
		
		      String[] word=s.split("");
		     HashSet<String > set = new HashSet<String>();
		      for(String words : word) {
		    	  if(! set.add(words)) {
		    		  System.out.print(words);
		    	  }
		      }
		   
			
	}
}
