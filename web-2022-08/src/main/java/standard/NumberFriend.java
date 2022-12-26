package standard;

import java.util.ArrayList;
import java.util.List;

public class NumberFriend {

	public static void main(String[] args) {
		NumberFriend nf = new NumberFriend();
		
//		String X1 = "100";
//		String Y1 = "2345";
//		System.out.println(nf.solution(X1, Y1));
//		
//		String X2 = "100";
//		String Y2 = "203045";
//		System.out.println(nf.solution(X2, Y2));
		
		String X3 = "100";
		String Y3 = "123450";
		System.out.println(nf.solution(X3, Y3));
	}
	
	String solution(String X, String Y) {
		StringBuilder sb = new StringBuilder();
		
		List<Integer> listX = new ArrayList<>();
		String[] tempX = X.split("");
		for(String x : tempX) {
			listX.add(Integer.parseInt(x));
		}
		
		System.out.println(listX.toString());
		List<Integer> listY = new ArrayList<>();
		String[] tempY = Y.split("");
		for(String y : tempY) {
			listY.add(Integer.parseInt(y));
		}
		
		listX.retainAll(listY);
		System.out.println(listY.toString());
		System.out.println(listX.toString());
		if(listX.size() == 0) {
			sb.append("-1");
		} else {
			int max = 0;
			int remover = 0;
			
			while(listX.size() > 0) {
				for(int i=0; i<listX.size(); i++) {
					max = 0;
					
					if(listX.get(i) > max) {
						max = listX.get(i);
						remover = i;
					}
				}
				
				sb.append(max);
				listX.remove(remover);
			}
		}
		
		if(sb.toString().substring(0, 1).equals("0")) {
			sb.setLength(0);
			sb.append("0");
		}
		return sb.toString();
	}

}
