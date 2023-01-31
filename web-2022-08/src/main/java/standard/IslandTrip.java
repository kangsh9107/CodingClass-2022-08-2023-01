package standard;

import java.util.ArrayList;
import java.util.List;

public class IslandTrip {

	public static void main(String[] args) {
		IslandTrip it = new IslandTrip();
		
		String[] maps1 = {"X591X", "X1X5X", "X231X", "1XXX1"};
		System.out.println(it.solution(maps1));
		
//		String[] maps2 = {"XXX", "XXX", "XXX"};
//		System.out.println(it.solution(maps2));
	}
	
	public List<Integer> solution(String[] maps) {
		int countX = 0;
		int countM = 0;
		for(int i=0; i<maps.length; i++) {
			countX += maps[i].length() - maps[i].replace("X", "").length();
		}
		for(int i=0; i<maps.length; i++) {
			countM += maps[i].length();
		}
		if(countX == countM) {
			List<Integer> noFood = new ArrayList<>();
			noFood.add(-1);
			return noFood;
		}
		
		int rows = maps[0].length();
		int columns = maps.length;
		String[][] food = new String[columns][rows];
		List<Integer> answer = new ArrayList<>();
		for(int i=0; i<columns; i++) {
			for(int j=0; j<rows; j++) {
				food[i][j] = maps[i].split("")[j];
			}
		}
		
		
		
		return answer;
	}

}
