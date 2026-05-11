package interview;

import java.util.HashSet;

public class FindDupArray {

	public static void main(String[] args) {
	int arr[]= {12,2,3,3,45,55,45,60,60};
	HashSet<Integer> set = new HashSet();
     for(int num:arr) {
    	 if(set.add(num)) {
    		 continue;
    		// System.out.println("unique charectors are :"+num); 
    	 }
    	 System.out.println("Dup charectors are :"+num); 
     }

	}

}
