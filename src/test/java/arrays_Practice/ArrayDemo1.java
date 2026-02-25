package arrays_Practice;

public class ArrayDemo1 {

	public static void main(String[] args) {
		/*What is an Arrya?
		Ans: Array is a collection of similar data types.
        */
		
		int age[] = {21,22,34,43,90};
		int age2[] = new int[6];
		age2[0]=12;
		age2[1]=22;
		age2[2]=32;
		age2[3]=14;
		age2[5]=72;
		 for(int i=0;i<age2.length-1;i++) {
			 System.err.println(age2[i]);
		 }
		System.out.println("------------");
		System.out.println(age[2]);
		
	}

}
