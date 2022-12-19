package standard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Stack {

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
//		int[] arr = {4,4,4,3,3};
		HashSet<Integer> hs = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			if(hs.add(arr[i])) {
				list.add(arr[i]);
			} else {
				if(list.size() > 0) {
					if(list.get(list.size()-1) != arr[i]) {
						list.add(arr[i]);
					}
				}
			}
		}
		
		System.out.println(list);
	}

}
