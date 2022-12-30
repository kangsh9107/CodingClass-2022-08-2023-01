package standard;

public class P221230 {

	public static void main(String[] args) {
		P221230 p = new P221230();
		
//		int n1 = 6;
//		System.out.println(p.solution(n1));
//		
//		int n2 = 16;
//		System.out.println(p.solution(n2));
		
		int n3 = 626331;
		System.out.println(p.solution(n3));
	}
	
	int solution(int num) {
		int answer = 0;
		
		while(answer < 500) {
			if(num == 1) break;
			answer++;
			
			if(num % 2 == 0) num /= 2;
			else             num = (num * 3) + 1;
		}
		
		if(answer == 500) answer = -1;
		
		return answer;
	}

}
