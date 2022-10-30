package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P221031 {

	public static void main(String[] args) throws IOException {
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<test; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			System.out.println(tanget_point(x1, y1, r1 , x2, y2, r2));
		}
		*/
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for(int i=0; i<test; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(br.readLine());
			int ans = 0;
			
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				boolean flag1 = false;
				boolean flag2 = false;
				
				if( Math.pow(x1-x, 2)+Math.pow(y1-y, 2) > Math.pow(r, 2) ) flag1 = true;
				
				if( Math.pow(x2-x, 2)+Math.pow(y2-y, 2) > Math.pow(r, 2) ) flag2 = true;
				
				if(flag1 != flag2) ans++;
			}
			
			System.out.println(ans);
		}
		*/
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = gcd(a, b);
		
		System.out.println(d);
		System.out.println(a * b / d);
		*/
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for(int i=0; i<test; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = gcd(a, b);
			
			System.out.println(a * b / d);
		}
		*/
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		int[] arr = new int[test];
		
		for(int i=0; i<test; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int gcdVal = arr[1] - arr[0];
		
		for(int i=2; i<test; i++) {
			gcdVal = gcd(gcdVal, arr[i] - arr[i-1]);
		}
		
		for(int i=2; i<=gcdVal; i++) {
			if(gcdVal%i == 0) {
				System.out.println(i);
			}
		}
		*/
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int firstRing = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<test; i++) {
			int otherRing = Integer.parseInt(st.nextToken());
			int gcd = gcd(firstRing, otherRing);
			
			System.out.println((firstRing / gcd) + "/" + (otherRing / gcd));
		}
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println( factorial(N) / (factorial(N-K)*factorial(K)) );
	}
	
	public static int factorial(int N) {
		if(N <= 1) return 1;
		
		return N * factorial(N-1);
	}

	public static int gcd(int a, int b) {
		if(b == 0) return a;
		
		return gcd(b, a % b);
	}
	
	/*
	public static int tanget_point(int x1, int y1, int r1, int x2, int y2, int r2) {
		int distance_pow = (int)( Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) );
		
		if(x1==x2 && y1==y2 && r1==r2) {
			return -1;
		} else if(distance_pow > Math.pow(r1+r2, 2)) {
			return 0;
		} else if(distance_pow < Math.pow(r2-r1, 2)) {
			return 0;
		} else if(distance_pow == Math.pow(r2-r1, 2)) {
			return 1;
		} else if(distance_pow == Math.pow(r1+r2, 2)) {
			return 1;
		} else {
			return 2;
		}
	}
	*/

}
