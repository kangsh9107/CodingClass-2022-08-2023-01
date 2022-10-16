package standard;

import java.util.Arrays;
import java.util.Collections;

public class P221016 {
	
	public static void main(String[] args) {
		
		/*
		Integer[] arr = new Integer[5];
		
		for(int i=0; i<5; i++) {
			arr[i] = 1;
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		double a = 1.123;
		double b = Math.round(a);
		System.out.println(b);
		*/
		
		StringBuilder sb = new StringBuilder();
		
		int N = 5;
		Integer[] arr = {-1,-2,-3,-1,-2};
		double sum = 0;

		for(int i=0; i<N; i++) {
			sum += arr[i];
		}

		Arrays.sort(arr);
		
		boolean flag = false;
		int mode_max = 0;
		int mode = 10000;
		
		for(int i = 0; i<N; i++) {
			int jump = 0;
			int count = 1;
			int i_value = arr[i];

			for(int j = i + 1; j<N; j++) {
				if(i_value != arr[j]) break;

				count++;
				jump++;
			}

			if(count > mode_max) {
				mode_max = count;
				mode = i_value;
				flag = true;
			} else if(count == mode_max && flag == true) {
				mode = i_value;
				flag = false;
			}
			i += jump;
		}

		sb.append(arr[N/2]).append("\n");
		sb.append(mode).append("\n");
		sb.append( arr[N-1] - arr[0] );

		System.out.println(String.format("%.0f", sum/N));
		System.out.print(sb);
	}
	
}
