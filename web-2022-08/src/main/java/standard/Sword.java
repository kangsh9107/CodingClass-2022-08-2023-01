package standard;

public class Sword {

	public static void main(String[] args) {
		Sword s = new Sword();
		int number = 5;
		int limit = 3;
		int power = 2;
		System.out.println(s.solution(number, limit, power));
		
		number = 10;
		limit = 3;
		power = 2;
		System.out.println(s.solution(number, limit, power));
	}
	
	public int solution(int number, int limit, int power) {
		int answer = 0;
		int cnt = 0;
		
		for(int i=1; i<=number; i++) {
			cnt = 0;
			
			for(int j=1; j*j<=i; j++) {
				if(j * j == i)       cnt++;
				else if (i % j == 0) cnt += 2;
			}
			
			if(cnt > limit) answer += power;
			else            answer += cnt;
		}
		
		return answer;
	}

}
