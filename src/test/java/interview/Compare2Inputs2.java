package interview;

public class Compare2Inputs2 {

	public static void main(String[] args) {
		int[] input1= {1,2,3,4,5};
		int remove=3;
		int[] input2= new int[input1.length-1];
		int index=0;
		for(int i=0;i<input1.length;i++) {
			if(input1[i]!=remove) {
				input2[index]=input1[i];
				index++;
			}
		}
		for(int i=0;i<input2.length;i++) {
			System.out.print(input2[i]+" ");
		}
	}

}
