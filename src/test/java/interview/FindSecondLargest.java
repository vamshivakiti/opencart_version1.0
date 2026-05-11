
package interview;

public class FindSecondLargest {

	public static void main(String[] args) {
		int arr[]= {12,39,11,97,2,99,14,98};
		int largest = arr[0];
		int sec_lar=arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>largest) {
				sec_lar=largest;
				largest=arr[i];
				
			
			}
			else if(arr[i]>sec_lar && arr[i] != largest) {
				System.out.println("Second largest :"+sec_lar);
			}
		}
		
	}

}
