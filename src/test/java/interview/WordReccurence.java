package interview;

import java.util.HashMap;
import java.util.Map;

public class WordReccurence {

	public static void main(String[] args) {
		String input= "QA Automation testing QA manual testing";
		String[]words= input.split("//s");
		HashMap<String, Integer> number= new HashMap<String, Integer>();
		for(String word: words) {
			number.put(word, number.getOrDefault(word, 0)+1);
		}
		
		 for (Map.Entry<String, Integer> entry : number.entrySet()) {
	            System.out.println(entry.getKey() + " -> " + entry.getValue());
	        }
	}

}
