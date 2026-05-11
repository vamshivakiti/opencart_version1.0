package interview;

import java.util.HashSet;

public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		String input = "automation java";
//		String result="";
//		for(int i=0;i<input.length();i++) {
//			
//			char c=input.charAt(i);
//			if(result.indexOf(c)==-1) {
//				result=result+c;
//			}
//		}
//		System.out.println(result);
		
		HashSet<Character> uniqCha= new HashSet();
		for(char c:input.toCharArray()) {
			uniqCha.add(c);
		}
		//System.out.println("Unique char");
			for(char ch :uniqCha) {
				System.out.print(ch);
			}
		}
	}

