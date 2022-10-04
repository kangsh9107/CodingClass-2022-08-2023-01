package control;

public class BreakAndContinue {

	public void breakTest() {
		int n = 1;
		while(n<10) {
			System.out.print(n);
			if(n>=5) break;
			n++;
		}
		System.out.println("");
		int n2 = 1;
		while(n2<10) {
			n2++;
			if(n2>=5) break;
			System.out.print(n2);
		}
	}
	
	public static void main(String[] args) {
		BreakAndContinue bac = new BreakAndContinue();
		bac.breakTest();
	}
	
}
