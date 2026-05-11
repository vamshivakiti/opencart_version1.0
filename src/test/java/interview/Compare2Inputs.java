package interview;

public class Compare2Inputs {

	public static void main(String[] args) {
		//Use Set
		int[] input1= {1,2,3,4,5};
		int remove=3;
		for(int i=0;i<input1.length;i++) {
			if(input1[i]==remove) {
				continue;
			}
			System.out.print(input1[i]+" ");
		}
		
	}

}
