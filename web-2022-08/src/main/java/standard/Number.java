package standard;

import java.util.ArrayList;
import java.util.List;

public class Number {
	static int index = 0;
	
	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
//		int[] arr = {4, 4, 4, 3, 3};
		List<Integer> list = new ArrayList<>();
		for(int i : arr) {
			list.add(i);
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) == list.get(i+1)) {
				
			}
		}
		
		System.out.println(list);
	}

}
