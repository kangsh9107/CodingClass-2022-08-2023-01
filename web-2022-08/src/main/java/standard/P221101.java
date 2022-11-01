package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P221101 {
	//public static final int div = 10007;
	public static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println( (factorial(N) * mod_inverse((factorial(N-K)*factorial(K)) % div, div-2) % div) );
		*/
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		
		for(int i=0; i<test; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(combi(M, N)).append("\n");
		}
		
		System.out.println(sb);
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test = Integer.parseInt(br.readLine());
		
		for(int i=0; i<test; i++) {
			HashMap<String, Integer> hm = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			
			for(int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken(); // 옷 이름 버림
				String kind = st.nextToken();
				
				if(hm.containsKey(kind)) {
					hm.put(kind, hm.get(kind)+1);
				} else {
					hm.put(kind, 1);
				}
			}
			
			int result = 1;
			
			for(int v : hm.values()) {
				result *= (v + 1);
			}
			
			sb.append(result-1).append("\n");
		}
		
		System.out.println(sb);
	}
	
	/*
	public static int combi(int n, int r) {
		if(dp[n][r] > 0) return dp[n][r];
		
		if(n==r || r==0) return dp[n][r] = 1;
		
		return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
	}
	*/
	/*
	public static int factorial(int N) {
		if(N <= 1) return 1;
		
		return (N*factorial(N-1)) % div;
	}
	
	public static int mod_inverse(int a, int p) {
		int ret = 1;
		
		while(p > 0) {
			if(p%2 == 1) {
				ret *= a;
				p--;
				ret %= div;
			}
			
			a *= a;
			a %= div;
			p >>= 1; // p = p/2;
		}
		
		return ret;
	}
	*/
}
