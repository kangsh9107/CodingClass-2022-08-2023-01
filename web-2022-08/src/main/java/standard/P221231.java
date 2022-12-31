package standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P221231 {

	public static void main(String[] args) {
		P221231 p = new P221231();
		
		int n1 = 6;
		System.out.println(p.solution(n1));
		
		int n2 = 16;
		System.out.println(p.solution(n2));
		
		int n3 = 626331;
		System.out.println(p.solution(n3));
	}
	
	int solution(int num) {
		int answer = 0;
		long l = (long)num;
		
		while(answer < 500) {
			if(l == 1) break;
			answer++;
			if(answer == 500) {
				answer = -1;
				break;
			}
			
			if(l % 2 == 0) l = l / 2;
			else           l = (l * 3) + 1;
		}
		
		return answer;
	}

}
