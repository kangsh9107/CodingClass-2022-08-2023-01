package standard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P221009 {

	public static void main(String[] args) throws IOException {
		int a = 26;
		int ten = 0;
		int one = 0;
		int sum = 0;
		int next = 0;
		int cnt = 1;
		
		ten = a / 10;
		one = a % 10;
		sum = ten + one;
		next = (one * 10) + sum % 10;
		
		while(a!=next) {
			ten = next / 10;
			one = next % 10;
			sum = ten + one;
			next = (one * 10) + sum % 10;
			cnt++;
		}
		System.out.println(cnt);
		
		// --------------------------------------------------
		System.out.println("-".repeat(50));
		int star = 5;
		String r1 = "";
		String r2 = "";
		
		for(int i=0; i<star; i++) {
			r1 = "";
			r2 += "*";
			for(int k=i; k<star-1; k++) {
				r1 += " ";
			}
			System.out.println(r1 + r2);
		}
		
		// --------------------------------------------------
		System.out.println("-".repeat(50));
        int aa = 5;
        int min = 1000001;
        int max = 0;
        int[] arr = new int[aa];

        for(int i=0; i<aa; i++) {
        	arr[i] = 1;
            if(arr[i] < min) min = arr[i];
            if(arr[i] > max) max = arr[i];
        }
        System.out.println(Arrays.toString(arr));
        
		// --------------------------------------------------
		System.out.println("-".repeat(50));
		int[] arr2 = new int[9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int i=0; i<5; i++) {
        	for(int k=i; k<5; k++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
	}
	
}









