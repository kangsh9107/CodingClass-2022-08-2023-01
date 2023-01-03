package standard;

public class GcdLcm {

	public static void main(String[] args) {
		GcdLcm gl = new GcdLcm();
		
		int n1 = 3;
		int m1 = 12;
		System.out.println(gl.solution(n1, m1));
		
		int n2 = 2;
		int m2 = 5;
		System.out.println(gl.solution(n2, m2));
	}
	
	int[] solution(int n, int m) {
		int a = gcd(n, m);
		int b = (n * m) / a;
		
		int[] answer = {a, b};
		return answer;
	}
	
	int gcd(int a, int b) {
		int large = Math.max(a, b);
		int small = Math.min(a, b);
		
		if(b == 0) return large;
		else       return gcd(small, large % small);
	}
	
}
