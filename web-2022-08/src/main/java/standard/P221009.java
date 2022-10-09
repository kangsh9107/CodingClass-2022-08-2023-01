package standard;

public class P221009 {

	public static void main(String[] args) {
		int a = 26;
		int ten = 0;
		int one = 0;
		int sum = 0;
		int next = 0;
		int cnt = 1;
		
		ten = a / 10;
		one = a % 10;
		sum = ten + one;
		next = (one * 10) + sum % 10;
		
		while(a!=next) {
			ten = next / 10;
			one = next % 10;
			sum = ten + one;
			next = (one * 10) + sum % 10;
			cnt++;
		}
		System.out.println(cnt);
		
		
		// --------------------------------------------------
		System.out.println("-".repeat(50));
		int star = 5;
		String r1 = "";
		String r2 = "";
		
		for(int i=0; i<star; i++) {
			r1 = "";
			r2 += "*";
			for(int k=i; k<star-1; k++) {
				r1 += " ";
			}
			System.out.println(r1 + r2);
		}
	}
	
}









