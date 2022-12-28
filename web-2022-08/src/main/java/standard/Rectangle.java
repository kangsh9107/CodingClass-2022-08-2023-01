package standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rectangle {

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		
		int[][] sizes1 = {{60,50}, {30,70}, {60,30}, {80,40}};
		System.out.println(r.solution(sizes1));
		
		int[][] sizes2 = {{10,7}, {12,3}, {8,15}, {14,7},{5,15}};
		System.out.println(r.solution(sizes2));
		
		int[][] sizes3 = {{14,4}, {19,6}, {6,16}, {18,7}, {7,11}};
		System.out.println(r.solution(sizes3));
	}
	
	int solution(int[][] sizes) {
		int answer = 0;
		
		List<Integer> great = new ArrayList<>();
		List<Integer> less = new ArrayList<>();
		for(int i=0; i<sizes.length; i++) {
			if(sizes[i][0] > sizes[i][1]) {
				great.add(sizes[i][0]);
				less.add(sizes[i][1]);
			} else {
				great.add(sizes[i][1]);
				less.add(sizes[i][0]);
			}
		}
		
		Collections.sort(great);
		Collections.sort(less);
		answer = great.get(great.size()-1) * less.get(less.size()-1);
		
		return answer;
	}

}
