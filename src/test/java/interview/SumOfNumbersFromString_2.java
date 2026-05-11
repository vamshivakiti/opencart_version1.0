package interview;

import java.util.Scanner;

public class SumOfNumbersFromString_2 {

	public static void main(String[] args) {
String input = "12@#3)(4dg567hh89";
int sum=0;
for(char ch: input.toCharArray()) {
	if(Character.isDigit(ch)) {
		sum=sum+ch-'0';
	}
}
System.out.println("Sum of numbers from string is: "+sum);

	}
}
