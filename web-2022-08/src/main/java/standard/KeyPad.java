package standard;

import java.util.ArrayList;
import java.util.List;

public class KeyPad {
	public static void main(String[] args) {
		KeyPad k = new KeyPad();
		
		int[] numbers1 = {1,3,4,5,8,2,1,4,5,9,5};
		String hand1 = "right";
		System.out.println(k.solution(numbers1, hand1));
		
//		int[] numbers2 = {7,0,8,2,8,3,1,5,7,6,2};
//		String hand2 = "left";
//		System.out.println(k.solution(numbers2, hand2));
//		
//		int[] numbers3 = {1,2,3,4,5,6,7,8,9,0};
//		String hand3 = "right";
//		System.out.println(k.solution(numbers3, hand3));
	}
	
	public String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();

		List<Integer> lt = new ArrayList<>();
		List<Integer> rt = new ArrayList<>();
		lt.add(0);
		lt.add(0);
		rt.add(2);
		rt.add(0);
		
		List<Integer> keys = new ArrayList<>();
		int n = 0;
		int y = 0;
		for(int i=0; i<numbers.length; i++) {
			n = numbers[i];
			
			if(n == 1 || n == 4 || n == 7) {
				if(n == 1)      y = 3;
				else if(n == 4) y = 2;
				else            y = 1;
				sb.append("L");
				lt.clear();
				lt.add(0);
				lt.add(y);
			} else if(n == 3 || n == 6 || n == 9) {
				if(n == 3)      y = 3;
				else if(n == 6) y = 2;
				else            y = 1;
				sb.append("R");
				rt.clear();
				rt.add(2);
				rt.add(y);
			} else {
				if(n == 2)      y = 3;
				else if(n == 5) y = 2;
				else if(n == 8) y = 1;
				else            y = 0;
				keys.add(1);
				keys.add(y);
				
				int r1 = lt.get(0) - keys.get(0);
				int r2 = lt.get(1) - keys.get(1);
				int d1 = (r1*r1) + (r2*r2);
				r1 = rt.get(0) - keys.get(0);
				r2 = rt.get(1) - keys.get(1);
				int d2 = (r1*r1) + (r2*r2);
				
				if(d1 < d2) {
					sb.append("L");
					keys.clear();
					lt.clear();
					lt.add(1);
					lt.add(y);
				} else if(d1 > d2) {
					sb.append("R");
					keys.clear();
					rt.clear();
					rt.add(1);
					rt.add(y);
				} else {
					if(hand.equals("left")) {
						sb.append("L");
						keys.clear();
						lt.clear();
						lt.add(1);
						lt.add(y);
					} else {
						sb.append("R");
						keys.clear();
						rt.clear();
						rt.add(1);
						rt.add(y);
					}
				}
			}
		}
		
		return sb.toString();
	}

}
