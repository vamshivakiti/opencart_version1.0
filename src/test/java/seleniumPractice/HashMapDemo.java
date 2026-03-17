package seleniumPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hp = new HashMap();
		hp.put(1,"mango");
		hp.put(2, "Banana");
		hp.put(2, "oker");
		hp.put(3, null);
		hp.put(3, "Grape");
		System.out.println(hp.get(2));
		
System.out.println(hp);

HashSet set = new HashSet();
set.add(null);
set.add(null);
set.add("Fish");
set.add("Meat");
System.out.println(set);

List myList = new ArrayList();
myList.add("Mango");
myList.add(1000);
myList.add('P');

System.out.println(myList);
	}

}
