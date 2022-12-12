package standard;

public class Cola {
	
	public static void main(String[] args) {
		int answer = 0;
		int a = 3;
		int b = 1;
		int n = 20;
		
		while(n >= a) {
			answer += (int)(n/a)*b;
			n = (n - (((int)(n/a))*a)) + (int)(n/a)*b;
		}
		
		System.out.println(answer);
	}
	
}
