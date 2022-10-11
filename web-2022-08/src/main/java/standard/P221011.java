package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P221011 {
	public static void main(String[] args) throws IOException {
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
	}
}









