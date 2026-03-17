package interview;

import java.util.Scanner;

public class SumOfNumbersFromString {

	public static void main(String[] args) {
String input = "1hih3jl45ll9ygu10uu";
int sum=0;
String number ="";
for(int i =0; i<input.length();i++) {
	char ch = input.charAt(i);
	if(Character.isDigit(ch)) {
		number=number+ch;
	}
	else {
		if(!number.isEmpty()) {
			sum=sum+Integer.parseInt(number);
			number="";
		}
	}
}
if(!number.isEmpty()) {
	sum=sum+Integer.parseInt(number);
	number="";
}
System.out.println("Sum ="+sum);


//String input2="6jhgg87hyg@78*u";
Scanner sc = new Scanner(System.in);
System.out.println("Enter the value with alpha numeric");
String input2 =sc.nextLine();
int sum2=0;
String number2 ="";
for(int i=0;i<input2.length();i++) {
	char ch2 =input2.charAt(i);
	if(Character.isDigit(ch2)) {
		number2=number2+ch2;
	}
	else {
		if(!number2.isEmpty()) {
			sum2=sum2+Integer.parseInt(number2);
			number2="";
		}
	}
	 {
		if(!number2.isEmpty()) {
			sum2=sum2+Integer.parseInt(number2);
			number2="";
		}
	}
}

System.out.println(sum2);



	}
}
