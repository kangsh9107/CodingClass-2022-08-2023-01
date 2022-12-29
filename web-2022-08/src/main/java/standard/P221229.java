package standard;

public class P221229 {

	public static void main(String[] args) {
//		String s = "-1123";
//        int answer = 0;
//        
//        if(s.substring(0,1).equals("-")) {
//            answer = Integer.parseInt(s) - 2*Integer.parseInt(s);
//        } else {
//            answer = Integer.parseInt(s);
//        }
//        
//        System.out.println(answer);
		
		P221229 p = new P221229();
		
//		int n1 = 6;
//		System.out.println(p.solution(n1));
//		
//		int n2 = 16;
//		System.out.println(p.solution(n2));
//		
		int n3 = 626331;
		System.out.println(p.solution(n3));
	}
	
	int solution(int num) {
		int answer = 0;
		
		while(answer < 500) {
			System.out.println(num);
			if(num % 2 == 0) num = (num / 2);
			else             num = (num * 3) + 1;
			
			answer++;
			if(num == 1) break;
		}
		
		if(answer >= 500) answer = -1;
		
		return answer;
	}

}
