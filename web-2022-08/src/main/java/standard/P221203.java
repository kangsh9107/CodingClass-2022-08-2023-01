package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P221203 {
	static int n, k, t;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=k; i<=n; i++) {
			combination(arr, visited, 0, n, i);
		}
	}
	
	static boolean weight(int[] arrTemp) {
		boolean b = false;
		int sum = 0;
		
		for(int j=0; j<arrTemp.length; j++) {
			sum += arrTemp[j];
		}
		
		if(sum <= t) b = true;
		
		return b;
	}

	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			print(arr, visited, n);
			return;
		}
		
		for(int i=start; i<n; i++) {
			visited[i] = true;
			combination(arr, visited, i+1, n, r-1);
			visited[i] = false;
		}
	}
	
	static void print(int[] arr, boolean[] visited, int n) {
		for(int i=0; i<n; i++) {
			if(visited[i]) {
				System.out.println(arr[i] + " ");
			}
		}
		System.out.println();
	}
	
}
