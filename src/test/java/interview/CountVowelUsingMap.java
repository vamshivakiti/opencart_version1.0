package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountVowelUsingMap {

	public static void main(String[] args) {
		String str = "Hello this is autoation testing";
		HashMap<Character, Integer> map = new HashMap();
		//Set<Character>set = new HashSet<Character>();
		str.toLowerCase();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if((ch =='a')||(ch=='e')||(ch=='i')|| (ch=='o')||(ch=='u')) {
				// Using Set
				//if(set.contains(ch)) {					
				
          //    Using HashMap				
				if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
				}
				else {
					map.put(ch, 1);
			}
			}
		}
		System.out.println(map);
		}
	
}
