package interview;

import java.util.HashSet;

public class CompareTwoIntArrays {

	public static void main(String[] args) {
    int [] arr1 = {1,2,3,4,5};
    int []arr2= {2,3,5};
    
    HashSet<Integer> set = new HashSet<>();
    
    for(int n:arr2) {
    	set.add(n);
    }
    
    for(int n:arr1) {
    	if(!set.contains(n)) {
    		System.out.print(n+" ,");
    	}
    }
	}

}
