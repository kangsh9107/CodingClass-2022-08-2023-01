package standard;

public class ThreeMusketeers {
	int answer = 0;

	public static void main(String[] args) {
		ThreeMusketeers tm = new ThreeMusketeers();
		
		int[] number1 = {-2,3,0,2,-5};
		System.out.println(tm.solution(number1));
		
		int[] number2 = {-3,-2,-1,0,1,2,3};
		System.out.println(tm.solution(number2));
		
		int[] number3 = {-1,1,-1,1};
		System.out.println(tm.solution(number3));
	}
	
	int solution(int[] number) {
		answer = 0;
		boolean[] visited = new boolean[number.length];		
		combination(number, visited, 0, number.length, 3);
		return answer;
	}
	
	void combination(int[] number, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			int sum = sum(number, visited, n);
			if(sum == 0) answer++;
			return;
		}
		for(int i=start; i<n; i++) {
			visited[i] = true;
			combination(number, visited, i+1, n, r-1);
			visited[i] = false;
		}
	}
	
	int sum(int[] number, boolean[] visited, int n) {
		int sum = 0;
		for(int i=0; i<n; i++) {
			if(visited[i]) sum += number[i];
		}
		return sum;
	}

}
