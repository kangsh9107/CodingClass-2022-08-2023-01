package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P221019 {
	static int recursionCnt = 0;
	
	public static void main(String[] args) throws IOException {
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			int[] values = isPalindromeArray(br.readLine());
			int isPalindrome = values[0];
			int recursionCnt = values[1];
			
			sb.append(isPalindrome).append(" ").append(recursionCnt).append("\n");
		}
		
		System.out.println(sb);
		*/

		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		int[] arr = new int[N];
		int sum = 0;
		st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					sum = arr[i] + arr[j] + arr[k];
					if(sum <= M) list.add(sum);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println( list.get(list.size()-1) );
		*/
		
		int length = 123;
		System.out.println(Integer.toString(length).length());
	}
}

	/*
	public static int[] recursion(String s, int l, int r){
		recursionCnt++;
    	if(l >= r) {
    		return new int[] {1, recursionCnt};
    	} else if(s.charAt(l) != s.charAt(r)) {
    		return new int[] {0, recursionCnt};
    	} else {
    		return recursion(s, l+1, r-1);
    	}
	}

	public static int[] isPalindromeArray(String s){
		recursionCnt = 0;
    	return recursion(s, 0, s.length()-1);
    }
    */