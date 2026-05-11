package interview;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AscendingOrder {

	public static void main(String[] args) {
	int arr[] = {23,4,8,99,-1,0,7};
	Arrays.sort(arr);
	//System.out.println(arr);
for(int a: arr) {
	System.out.print(a+" ");
}
	System.out.println("---------------- ");
	for (int i =0; i<arr.length;i++) {
		for(int j =0; j<arr.length;j++) {
			if(arr[i]>arr[j]) {
				int temp =arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}
	
	for(int num: arr) {
		System.out.print(num+" ");
	}
	}

}
