package codingChallenge;

public class VowelsCount {

	public static void main(String[] args) {
	String input = "Automation";
	int count = 0;
	int consonets=0;
//	for(int i=0;i<input.length();i++) {
//		char ch = input.charAt(i);
//		if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ||
//		   ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
//			count++;
//		}}
//	System.out.println("Number of Vowels in the String: "+count);

	for(char ch:input.toCharArray()) {
		if("aeiouAEIOU".indexOf(ch)!=-1) {
			count++;
		}
		else {
			consonets++;
		}
	}
System.out.println("Number of Vowels in the String: "+count);
System.out.println("Number of Consonets in the String: "+consonets);
}
}