package test;

import java.util.ArrayList;
import java.util.List;

public class MapperTest {

	public static void main(String[] args) {
		List list = new ArrayList<String>();
		list.add("abc");
		System.out.println(list.get(0).getClass().getName());
		
		List list2 = new ArrayList<>();
		list2.add("abc");
		list2.add(1);
		System.out.println(list2.get(0).getClass().getName());
		System.out.println(list2.get(1).getClass().getName());
	}

}
