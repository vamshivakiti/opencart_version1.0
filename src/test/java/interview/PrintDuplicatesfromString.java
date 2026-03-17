package interview;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class PrintDuplicatesfromString {

	public static void main(String[] args) {
		String s = "ihihcuuhiuydiuhc";
//		char words[]=s.toCharArray();
//		
//		Set<Character> set = new HashSet<>();
//		for(char word:words) {
//			if(set.add(word)) {
//				System.out.print(word);		
//			}
		
//		}
		
		      String[] word=s.split("");
		      Set<String > set = new HashSet<String>();
		      for(String words : word) {
		    	  if(set.add(words)) {
		    		  System.out.print(words);
		    	  }
		      }
	}
}
