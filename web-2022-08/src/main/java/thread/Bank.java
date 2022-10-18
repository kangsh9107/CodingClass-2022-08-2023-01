package thread;

public class Bank {
	
	int amt = 1000;
	
	public synchronized void output(String n, int a) throws InterruptedException {
		if(amt >= a) {
			Thread.sleep(100);
			amt -= a;
		}
		System.out.print(n + " >>> ");
		System.out.printf("출금:%5d, 잔액:%5d\n", a, amt);
	}
	
}
