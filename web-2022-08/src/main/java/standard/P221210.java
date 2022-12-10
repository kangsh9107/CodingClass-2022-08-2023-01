package standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P221210 {
	static List<Integer> list = null;
	static int answer = 0;
	static int index = 0;
	
	public static void main(String[] args) {
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		Integer[] temp = new Integer[ingredient.length];
		for(int i=0; i<ingredient.length; i++) {
			temp[i] = ingredient[i];
		}
		
		list = new ArrayList<>(Arrays.asList(temp));
		
		for(int i=0; i<ingredient.length; i++) {
			remover(list);
		}
		
		System.out.println(answer);
	}
	
	public static void remover(List<Integer> list) {
		if(index-3 < 0) index = 0;
		
		for(int i=index; i<list.size(); i++) {
			if(list.get(i) == 1 && i <= list.size()-4) {
				if(list.get(i+1) == 2 && list.get(i+2) == 3 && list.get(i+3) == 1) {
					index = i - 3;
					answer++;
					
					for(int j=i; j<i+4; j++) {
						list.remove(i);
					}
					
					break;
				}
			}
		}
	}

}
