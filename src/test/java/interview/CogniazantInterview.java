package interview;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CogniazantInterview {
/*
 * Input: i love india
 * output: I_Love_India
 * */
	public static void main(String[] args) {
		String input= "i love india";
		String [] words=input.split(" ");
		String output="";
		for(String word:words) {
			output=output+Character.toUpperCase(word.charAt(0))
			+ word.substring(1)+"_";
			
		}
		output=output.substring(0, output.length()-1);	
         System.out.println(output);
//		
//		String revOut =Arrays.stream(output.split(" "))
//				.map(word -> new StringBuilder(word).reverse().toString())
//				.collect(Collectors.joining(" "));
//		         System.out.println(revOut);
	}

}
