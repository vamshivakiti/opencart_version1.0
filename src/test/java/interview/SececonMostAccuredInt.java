package interview;

import java.util.HashMap;
import java.util.Map.Entry;

public class SececonMostAccuredInt {

	public static void main(String[] args) {
		  int arr[] = {1,2,3,2,4,1,2,1,1,3,3,3,3,3};
		  HashMap<Integer, Integer> map = new HashMap<>();
		    for(int num : arr) {

	            map.put(num, map.getOrDefault(num, 0) + 1);
	        }
		    int firstMax = 0, secondMax = 0;
	        int firstNum = 0, secondNum = 0;
	        for(int key : map.keySet()) {

	            int count = map.get(key);

	            if(count > firstMax) {

	                secondMax = firstMax;
	                secondNum = firstNum;

	                firstMax = count;
	                firstNum = key;

	            }  else if(count > secondMax) {

	                secondMax = count;
	                secondNum = key;
	            }
	        }
	        System.out.println("Second most repeated number: " + secondNum);
	}

}
