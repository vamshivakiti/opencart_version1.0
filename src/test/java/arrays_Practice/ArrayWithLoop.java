package arrays_Practice;

import java.util.Iterator;
import java.util.Scanner;

public class ArrayWithLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		float[] marks = new float[5];
		System.out.println("Enter your marks for subject 1");
		marks[0]=sc.nextFloat();
		System.out.println("Enter your marks for subject 2");
		marks[2]=sc.nextFloat();
		System.out.println("Enter your marks for subject 3");
		marks[2]=sc.nextFloat();
		System.out.println("Enter your marks for subject 4");
		marks[3]=sc.nextFloat();
		System.out.println("Enter your marks for subject 5");
		marks[4]=sc.nextFloat();
		
		for(int i =0; i<marks.length;i++) {
			System.out.println("Marrks of sub :"+marks[i]);
			if(marks[i]<30) {
				System.out.println("You have failed in this sub :"+marks[i]);
			}
		}

	}

}
