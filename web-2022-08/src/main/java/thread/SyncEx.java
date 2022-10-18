package thread;

public class SyncEx {
	public static Bank b = new Bank();
	
	public SyncEx() {
		for(int i=0; i<100; i++) {
			OutThread ot = new OutThread();
			ot.start();
		}
	}

	class OutThread extends Thread {
		public void run() {
			int amt = (int)(Math.random()*100);
			try {
				b.output(getName(), amt);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new SyncEx();
	}
	
}









