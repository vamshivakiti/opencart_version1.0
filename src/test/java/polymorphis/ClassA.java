package polymorphis;

import java.util.HashMap;
import java.util.Map;

public class ClassA {

public static void main(String[] args) {
	int a =10;
	int b =0;
	try {
	int c =a/b;
	System.out.println(c);
	} catch ( ArithmeticException e) {
		System.out.println("Its a arthemetic exception");
		// TODO: handle exception
	}
	
	Map<Integer, String> myMao = new HashMap<Integer, String>();
	myMao.put(1, "Apple");
	myMao.put(1, null);
	myMao.put(1, "Orange");
	myMao.put(2, "Sapota");
	myMao.put(3, "Banana");
	System.out.println(myMao);
}
	
}
