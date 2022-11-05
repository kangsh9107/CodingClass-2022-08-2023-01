package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P221104 {

	public static void main(String[] args) throws IOException {
		/*
		String temp = "+";
		int a = 1;
		int b = 2;
		
		String test = a + temp + b;
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

}
