package begin;

public class IfTest {

	public void test1() {
		System.out.println("-----미션1-----");
		int[] scores = {90, 80, 79, 70, 60, 50, 40, 39};
		String msg = null;
		for(int i=0; i<scores.length; i++) {
			if(scores[i]>=80) {
				msg = "점수: " + scores[i] + "점 => 합격";
			}
			else if(scores[i]<40) {
				msg = "점수: " + scores[i] + "점 => 과락";
			}
			else {
				msg = "점수: " + scores[i] + "점 => 대기";
			}
			System.out.println(msg);
		}
	}
	
	public void test2() {
		System.out.println("\n-----미션2-----");
		int price = 1000;
		int ea = 1;
		int amount = (int) (price * ea/1.1 + 0.5);
		int tax = (int) (amount * 0.1 + 0.5);
		int totAmount = (int) (amount + tax);
		String msg = "";
		
		if(totAmount>=1000) msg = "비행기";
		else if(totAmount>=500) msg = "자동차";
		else if(totAmount>=300) msg = "자전거";
		else msg = "화장지";
		
		StringBuilder sb = new StringBuilder();
		sb.append("수량: " + ea + "개\n");
		sb.append("단가: " + price + "원\n");
		sb.append("세금: " + tax + "원\n");
		sb.append("금액: " + amount + "원\n");
		sb.append("총액: " + totAmount + "원\n");
		sb.append("사은품: " + msg + "입니다.\n");
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		IfTest it = new IfTest();
		it.test1();
		it.test2();
	}
	
}
