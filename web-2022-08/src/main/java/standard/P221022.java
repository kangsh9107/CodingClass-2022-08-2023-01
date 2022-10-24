package standard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P221022 {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(binarySearch(num)) bw.write("1 ");
			else                  bw.write("0 ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean binarySearch(int num) {
		int leftIndex = 0;
		int rightIndex = N - 1;
		
		while(leftIndex <= rightIndex) {
			int midIndex = (leftIndex+rightIndex) / 2;
			int mid = arr[midIndex];
			
			if(num < mid) rightIndex = midIndex - 1;
			else if(num > mid) leftIndex = midIndex + 1;
			else return true;
		}
		
		return false;
	}

}









