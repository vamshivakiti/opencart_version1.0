package interview;

import java.util.Scanner;

public class Print10Table {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter which table you want to print?");
	  int n=sc.nextInt();
	  for(int i=1;i<=10;i++) {
		 System.out.println(n +" x "+i +" = "+(n*i));
	  }

	}

}
