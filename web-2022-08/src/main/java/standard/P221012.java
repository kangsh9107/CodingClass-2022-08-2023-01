package standard;

import java.util.Arrays;

public class P221012 {
	
	public static void main(String[] args) {
		
		/*
		int a = 734;
		int b = 893;
		int m = Math.max(a, b);

		int hun = m / 100;
		int ten = (m / 10) % 10;
		int one = m % 10;
		
		System.out.println(one + "" + ten + "" + hun);
		*/
		
		/*
		String B = "123";
		StringBuffer sbB = new StringBuffer(B);
		StringBuffer reversedB = sbB.reverse();
		String reversedC = sbB.reverse().toString();
		System.out.println(reversedB);
		System.out.println(reversedC);
		System.out.println(reversedB.equals(reversedC));
		*/
		
		String s = "WA";
		String[] arr = s.split("");
		int cnt = 0;

		for(int i=0; i<s.length(); i++) {
			if(arr[i].equals("A") || arr[i].equals("B") || arr[i].equals("C")) cnt += 3;
			else if(arr[i].equals("D") || arr[i].equals("E") || arr[i].equals("F")) cnt += 4;
			else if(arr[i].equals("G") || arr[i].equals("H") || arr[i].equals("I")) cnt += 5;
			else if(arr[i].equals("J") || arr[i].equals("K") || arr[i].equals("L")) cnt += 6;
			else if(arr[i].equals("M") || arr[i].equals("N") || arr[i].equals("O")) cnt += 7;
			else if(arr[i].equals("P") || arr[i].equals("Q") || arr[i].equals("R") || arr[i].equals("S")) cnt += 8;
			else if(arr[i].equals("T") || arr[i].equals("U") || arr[i].equals("V")) cnt += 9;
			else if(arr[i].equals("W") || arr[i].equals("X") || arr[i].equals("Y") || arr[i].equals("Z")) cnt += 10;
		}
		System.out.print(cnt);
	}

}









