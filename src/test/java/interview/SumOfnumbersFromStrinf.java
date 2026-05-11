package interview;

public class SumOfnumbersFromStrinf {

	public static void main(String[] args) {
	String input = "abc123def456ghi789";
	int sum=0;
	String num="";
	for(int i=0;i<input.length();i++) {
		char ch=input.charAt(i);
		if(Character.isDigit(ch)) {
			num=num+ch;
		}
		else {if(!num.isEmpty()) {
			sum=sum+Integer.parseInt(num);
			num="";
		}
	}}
	if(!num.isEmpty()) {
		sum=sum+Integer.parseInt(num);
		num="";
	}
	System.out.println("Sum is ="+sum);
	}

}
