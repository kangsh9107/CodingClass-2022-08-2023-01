package standard;

public class Three {

	public static void main(String[] args) {
		Three t = new Three();
		
		int n1 = 45;
		System.out.println(t.solution(n1));
		
		int n2 = 125;
		System.out.println(t.solution(n2));
		
		int n3 = 100000000;
		System.out.println(t.solution(n3));
		
		int n4 = 1;
		System.out.println(t.solution(n4));
		
		int n5 = 2;
		System.out.println(t.solution(n5));
		
		int n6 = 3;
		System.out.println(t.solution(n6));
	}
	
	int solution(int n) {
		if(n == 1 || n == 2) return n;
		
		StringBuilder sb = new StringBuilder();
		int mok = 0;
		int na = 0;
		while((int)(n/3) > 0) {
			mok = (int)(n/3);
			na = n%3;
			n = mok;
			sb.append(na);
		}
		sb.append(mok);
		
		String num = String.valueOf(Long.parseLong(sb.toString()));
		int numberThree = 1;
		int answer = 0;
		for(int i=num.length()-1; i>=0; i--) {
			answer += Long.parseLong(num.substring(i, i+1)) * numberThree;
			numberThree *= 3;
		}
		
		return answer;
	}

}
