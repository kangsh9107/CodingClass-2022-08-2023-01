package standard;

public class ThreeMusketeers {

	public static void main(String[] args) {
		ThreeMusketeers tm = new ThreeMusketeers();
		
		int n = 4;
		int[] arr = {1, 2, 3, 4};
		boolean[] visited = new boolean[n];
		
//		for(int i=1; i<=n; i++) {
//			System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
//			combination(arr, visited, 0, n, i);
//		}
		combination(arr, visited, 0, n, 1);
		
		int[] number1 = {-2,3,0,2,-5};
		System.out.println(tm.solution(number1));
		
		int[] number2 = {-3,-2,-1,0,1,2,3};
		System.out.println(tm.solution(number2));
		
		int[] number3 = {-1,1,-1,1};
		System.out.println(tm.solution(number3));
	}
	
	int solution(int[] number) {
		int answer = 0;
		
		
		
		return answer;
	}
	
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			print(arr, visited, n);
			return;
		}
		
		for(int i=start; i<n; i++) {
			visited[i] = true;
			combination(arr, visited, i+1, n, r-1);
			visited[i] = false;
		}
	}
	
	static void print(int[] arr, boolean[] visited, int n) {
		for(int i=0; i<n; i++) {
			if(visited[i]) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

}
