package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P221011 {
	public static void main(String[] args) throws IOException {
		/*
		int[] lotto = new int[6];
		
		for(int i=0; i<6; i++) {
			lotto[i] = (int)( (Math.random() * 45) + 1 );
			for(int k=0; k<i; k++) {
				if(lotto[i] == lotto[k]) i--;
			}
			
		}
		
		Arrays.sort(lotto);
		
		for(int v : lotto) {
			System.out.printf("[%d]", v);
		}
		
		// --------------------------------------------------
		System.out.println("-".repeat(50));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int min = 1000001;
		int max = -1000001;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			if(arr[i] < min) min = arr[i];
			if(arr[i] > max) max = arr[i];
		}
		
		System.out.print(min + " " + max);
		*/
		
		// --------------------------------------------------
		System.out.println("-".repeat(50));
		String S = "baekjoon";
		char[] abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int[] arr = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

		for(int i=0; i<S.length(); i++) {
			for(int k=0; k<26; k++) {
				if( S.charAt(i) == abc[k] && arr[k] == -1 ) {
					arr[k] = i;
				}
			}
		}

		for(int i=0; i<25; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print(arr[25]);
	}
}









