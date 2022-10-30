package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P221030 {

	public static void main(String[] args) throws IOException {
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[test];
		
		for(int i=0; i<test; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[test-1] * arr[0]);
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int fruits = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int maxWidth = 0;
		int maxHeight = 0;
		List<Integer> list = new ArrayList<>();
		int maxWidthIndex = 0;
		int maxHeightIndex = 0;
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			if(direction == 1 || direction == 2) {
				maxWidth = Math.max(maxWidth, length);
				list.add(length);
			} else {
				maxHeight = Math.max(maxHeight, length);
				list.add(length);
			}
			
			if( (direction == 1 || direction == 2) && (length >= maxWidth) ) maxWidthIndex = i;
			
			if( (direction == 3 || direction == 4) && length >= maxHeight) maxHeightIndex = i;
		}
		
		int emptyWidth = 0;
		int emptyHeight = 0;
		
		
		if(maxWidthIndex == 0) {
			emptyHeight = Math.abs(list.get(1) - list.get(5));
		} else if(maxWidthIndex == 5) {
			emptyHeight = Math.abs(list.get(0) - list.get(4));
		} else if(maxWidthIndex >= 1 && maxWidthIndex <= 4) {
			emptyHeight = Math.abs(list.get(maxWidthIndex+1) - list.get(maxWidthIndex-1));
		}
		
		if(maxHeightIndex == 0) {
			emptyWidth = Math.abs(list.get(1) - list.get(5));
		} else if(maxHeightIndex == 5) {
			emptyWidth = Math.abs(list.get(0) - list.get(4));
		} else if(maxHeightIndex >= 1 && maxHeightIndex <= 4) {
			emptyWidth = Math.abs(list.get(maxHeightIndex+1) - list.get(maxHeightIndex-1));
		}
		
		System.out.println( ((maxWidth*maxHeight) - (emptyWidth*emptyHeight)) * fruits );
	}

}









