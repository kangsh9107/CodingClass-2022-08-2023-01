package standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P221207 {
	static int answer = 0;
	static int index = 0;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		Integer[] temp = new Integer[ingredient.length];
		for(int i=0; i<ingredient.length; i++) {
			temp[i] = ingredient[i];
		}
		list.addAll(Arrays.asList(temp));
		
		for(int i=0; i<=list.size()-4; i++) {
        	complite(list);
		}
		
        System.out.println(answer);
	}
	
	public static void complite(List<Integer> list) {
		index = 0;
		
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) == 1 && i <= list.size()-4) {
                if(list.get(i+1) == 2 && list.get(i+2) == 3 && list.get(i+3) == 1) {
                    answer++;
                    index = i;
                    remove(index);
                    return;
                }
            }
        }
	}
	
	public static void remove(int index) {
		for(int i=index; i<index+4; i++) {
			list.remove(index);
		}
	}

}
