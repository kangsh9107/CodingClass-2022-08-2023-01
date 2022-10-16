package standard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class P221015 {

	public static void main(String[] args) throws IOException {
		
		/*
		int N = 3;
		String[] arr = {"71","79","37","1"};
		int cnt = 0;
		int ans = 0;

		for(int i=0; i<N; i++) {
			cnt = 0;
			int temp = Integer.parseInt(arr[i]);
			
			for(int j=2; j<=Math.sqrt(temp); j++) {
				if(temp%j == 0) cnt++;
				
				if(cnt == 2) {
					ans++;
					break;
				}
			}
		}
		System.out.print(ans);
		int bb = 4;
		double aa = Math.sqrt(bb);
		*/
		
		/*
		int M = 64;
		int N = 100;
		int sum = 0;
		int min = 0;

		for(int i=M; i<=N; i++) {
			if(isPrime(i)) {
				sum += i;
				if(min == 0) min = i;
			}
		}

		System.out.println(sum);
		System.out.println(min);
		*/
		
		/*
		int N = 72;


		if(N != 1) {
			int i = 2;
			while(N%i == 0) {
				System.out.println(i);
				N = N / i;
				i++;
				
				if(N%i == 0) break;
			}
		}
		*/
		
        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw   = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> temp = new LinkedList<>();
        
        int N = 5;
        int[] arr = {5,4,3,2,1};

		for(int i=N-1; i>=0; i--) {
			System.out.println(arr[i]);
		}
	}

/*
	public static boolean isPrime(int num) {
		if(num == 1) return false;

		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i == 0) return false;
		}

		return true;
	}
*/
	
}
