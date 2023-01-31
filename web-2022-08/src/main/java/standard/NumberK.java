package standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberK {

	public static void main(String[] args) {
		NumberK nk = new NumberK();
		
		int[] array = {1, 5, 2, 6, 3, 7, 4};
//		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[][] commands = {{2, 5, 3}};
		System.out.println(nk.solution(array, commands));
	}
	
	public List<Integer> solution(int[] array, int[][] commands) {
		List<Integer> answer = new ArrayList<>();
		int i = 0;
		int j = 0;
		int k = 0;
		for(int c=0; c<commands.length; c++) {
			i = commands[c][0] - 1;
			j = commands[c][1];
			k = commands[c][2] - 1;
			if(i == j) j++;
			List<Integer> temp = new ArrayList<>();
			for(int t=i; t<j; t++) {
				temp.add(array[t]);
			}
			Collections.sort(temp);
			answer.add(temp.get(k));
		}
		
		return answer;
	}

}
