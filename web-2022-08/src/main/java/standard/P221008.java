package standard;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;

public class P221008 {
    public static void main(String[] args) throws NumberFormatException, IOException {
		
    	/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 * int A = Integer.parseInt(br.readLine());
		 * 
		 * for(int i=0; i<A; i++) { StringTokenizer st = new
		 * StringTokenizer(br.readLine()); int B = Integer.parseInt(st.nextToken()); int
		 * C = Integer.parseInt(st.nextToken()); bw.write(B + C + "\n"); } bw.close();
		 */
        
    	// --------------------------------------------------
    	
        int A = 5;
        String str = "";
        
        for(int i=0; i<A; i++) {
        	str = "";
        	for(int j=i; j<A-1; j++) {
        		for(int k=i; k<A-1; k++) {
        			str += "*";
        			System.out.println(str + "*");
        		}
        	}
        }
        
    }
}
