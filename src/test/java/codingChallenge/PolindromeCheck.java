package codingChallenge;

public class PolindromeCheck {

	public static void main(String[] args) {
	String str = "Madam";
	String rev ="";
	for(int i=str.length()-1;i>=0;i--) {
		rev=rev+str.charAt(i);
	}
	if(str.equalsIgnoreCase(rev)) {
		System.out.println("Given String is Polindrome");
	}
	else {
		System.out.println("Given String is not Polindrome");
	}
	}

}
