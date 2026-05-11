package interview;

import java.util.HashMap;

public class RepeatedIntegerCount {

	public static void main(String[] args) {
    int [] input= {1,2,3,4,4,5,2,7,8,9,9,6,4,2,1,9,5,8};
 HashMap<Integer, Integer> map = new HashMap<>();
 for(int num:input) {
	 
	 map.put(num, map.getOrDefault(num, 0)+1);
 }
	System.out.println(map);
	
	 int firstMax=0, SecondMax=0;
	 int firstNum=0, seconNum=0;
	 for(int Key : map.keySet()) {
		 
		 int count =map.get(Key);
		 if(count >firstMax) {
			 SecondMax= firstMax;
			 seconNum=firstNum;
			 firstMax=count;
			 firstNum=Key;
			 
		 }
		 else if(count>SecondMax) {
			 SecondMax=count;
			 seconNum=Key;
		 }
	 }
	 System.out.println("Most repeated number: "+firstNum+" with count: "+firstMax);
	 System.out.println("Second most repeated number: "+seconNum+" with count: "+SecondMax);
}

}
