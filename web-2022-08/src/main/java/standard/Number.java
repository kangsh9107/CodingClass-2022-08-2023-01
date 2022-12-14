package standard;

import java.util.ArrayList;
import java.util.List;

public class Number {
	static int index = 0;
	
	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		List<Integer> list = new ArrayList<>();
		for(int i : arr) {
			list.add(i);
		}
		
		for(int i=0; i<arr.length; i++) {
			if(index < arr.length) remove(list);
			else if(index < 0) break;
			else break;
		}
		
		System.out.println(list);
	}
	
	static void remove(List<Integer> list) {
		if(index >= 0) {
			for(int i=index; i<list.size(); i++) {
				if(i+1 < list.size()) {
					if(list.get(i) == list.get(i+1)) {
						index = i;
						list.remove(i+1);
						return;
					}
				} else {
					index *= (-1);
				}
			}
		}
	}

}
