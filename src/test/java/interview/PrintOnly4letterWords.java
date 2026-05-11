package interview;

public class PrintOnly4letterWords {

	public static void main(String[] args) {
	String input="This is A test to print only to print four letter word in java ";
	String [] words = input.split(" ");
	for(String word:words) {
		if (word.length()==4) {
			System.out.print(word+" ");
		}
	}
	}

}
