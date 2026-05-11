package interview;

import java.util.HashMap;

public class FindFrequncyOfWords {

	public static void main(String[] args) {

		String str ="Automation";
		HashMap<Character, Integer>map= new HashMap<>();
		for(char c:str.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			else {
				map.put(c, 1);
			}
			
		}
			System.out.println(map);	
	}

}
