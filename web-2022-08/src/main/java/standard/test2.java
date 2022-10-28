package standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		int i = 0;
		for(String s1 : list) {
			System.out.println("i : " + i);
			System.out.println(list);
			
			list.remove("a");
			i++;
		}
		
		/*
			for(String s2 : list) {
				System.out.println("s2 : " + list.get(j));
				j++;
			}
		 */
	}

}
