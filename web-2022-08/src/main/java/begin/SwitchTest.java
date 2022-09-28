package begin;

public class SwitchTest {
	
	public SwitchTest() {
		char code = 'a';
		int price = 0;
		int ea = 100;
		int amt = 0;
		
		switch(code) {
		case 'a' : price=5; break;
		case 'b' : price=3; break;
		default : price=1; break;
		}
		
		amt = price * ea;
		System.out.println("금액:" + amt);
	}

	public static void main(String[] args) {
		SwitchTest st = new SwitchTest();
	}
	
}
