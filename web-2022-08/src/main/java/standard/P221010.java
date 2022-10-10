package standard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class P221010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<testCase; i++) {
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			double sum = 0;
			
			for(int k=0; k<n; k++) {
				int score = Integer.parseInt(st.nextToken());
				arr[k] = score;
				sum += score;
			}
			
			double avg = sum / n;
			int cnt = 0;
			
			for(int k=0; k<n; k++) {
				if(arr[k] > avg) cnt++;
			}
			
			System.out.printf("%.3f%\n",(cnt/n)*100);
		}
		
		// --------------------------------------------------
		System.out.println("-".repeat(50));
		
	}
}









