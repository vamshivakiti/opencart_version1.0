package interview;

public class PalindromeCheck {

	public static void main(String[] args) {
  String input = "ete";
  String rev="";
  for(int i=input.length()-1;i>=0;i--) {
	 rev=rev+input.charAt(i);
  }
  System.out.println(rev);
  if(input.equals(rev)) {
	  System.out.println(input+" is Plolindrome");
  }
  else {
	  System.out.println(input+" is not polindrome");
  }
	}

}
