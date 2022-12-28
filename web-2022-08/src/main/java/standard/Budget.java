package standard;

import java.util.Arrays;

public class Budget {

	public static void main(String[] args) {
		Budget b = new Budget();
		
		int[] d1 = {1,3,2,5,4};
		int budget1 = 9;
		System.out.println(b.solution(d1, budget1));
		
		int[] d2 = {2,2,3,3};
		int budget2 = 10;
		System.out.println(b.solution(d2, budget2));
	}
	
	int solution(int[] d, int budget) {
		int answer = 0;
		
		Arrays.sort(d);
		int sum = 0;
		for(int i=0; i<d.length; i++) {
			if(sum < budget) {
				sum += d[i];
				answer++;
				
				if(sum > budget) {
					sum -= d[i];
					answer--;
					break;
				}
			}
		}
		
		return answer;
	}

}
