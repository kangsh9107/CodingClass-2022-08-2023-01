package standard;

import java.util.Arrays;
import java.util.Comparator;

public class P221017 {

	public static void main(String[] args) {
		/*
		StringBuilder sb = new StringBuilder();
		Integer[][] arr = { {0,4 }, {1,2},
							{1,-1}, {2,2},
							{3,3 } };
		
		Arrays.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if( o1[1].equals(o2[1]) ) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		
		for(int i=0; i<5; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
		}
		System.out.println(sb);
		*/
		
		int temp = 0;
		char[] arr = {'a','b','c'};
		
		for(int i=0; i<arr.length; i++) {
			temp += arr[i];
		}
		System.out.println(temp);
	}
	
}
