package interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveListDups {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,2,3,4,4,4,5,6);
//		list.add(1);
//		list.add(1);
//		list.add(2);
//		list.add(3);
		Set<Integer>set = new HashSet(list);
		System.out.println(set);

	}

}
