package standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P221225 {

	public static void main(String[] args) {
		P221225 p = new P221225();
		
		String X1 = "100";
		String Y1 = "2345";
		System.out.println(p.solution(X1, Y1));
		
//		String X2 = "100";
//		String Y2 = "203045";
//		System.out.println(p.solution(X2, Y2));
//		
//		String X3 = "100";
//		String Y3 = "123450";
//		System.out.println(p.solution(X3, Y3));
//		
//		String X4 = "12321";
//		String Y4 = "42531";
//		System.out.println(p.solution(X4, Y4));
//		
//		String X5 = "5525";
//		String Y5 = "1255";
//		System.out.println(p.solution(X5, Y5));
	}
	
	String solution(String X, String Y) {
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> hmX = new HashMap<>();
		String[] splitX = X.split("");
		for(String x : splitX) {
			if(hmX.get(x) == null) hmX.put(x, 1);
			else hmX.put(x, hmX.get(x)+1);
		}
		
		HashMap<String, Integer> hmY = new HashMap<>();
		String[] splitY = Y.split("");
		for(String y : splitY) {
			if(hmY.get(y) == null) hmY.put(y, 1);
			else hmY.put(y, hmY.get(y)+1);
		}
		
		String[] keys = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		List<String> list = new ArrayList<>();
		for(String k : keys) {
			if(hmX.get(k) != null & hmY.get(k) != null) {
				if(hmX.get(k) < hmY.get(k)) {
					for(int i=0; i<hmX.get(k); i++) {
						list.add(k);
					}
				} else {
					for(int i=0; i<hmY.get(k); i++) {
						list.add(k);
					}
				}
			}
		}
		
		Collections.sort(list, Collections.reverseOrder());
		if(list.size() == 0) {
			sb.append("-1");
		} else if(list.get(0).equals("0")) {
			sb.setLength(0);
			sb.append("0");
		} else {
			for(String l : list) {
				sb.append(l);
			}
		}
		
		return sb.toString();
	}

}
