package thread;

public class ThreadEx {
	
	/* Thread 클래스를 상속 받아서 Thread를 만드는 방법 */
	public void test1() {
		T t1 = new T();
		T t2 = new T();
		T t3 = new T();
		System.out.println("[main thread 시작]");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("[main thread 종료]"); // 메인 스레드가 종료되어도 백그라운드에서 작업 스레드가 돌고 있다
	}
	
	/* Runnable을 구현해서 Thread를 만드는 방법 */
	public void test2() {
		R r1 = new R();
		R r2 = new R();
		R r3 = new R();
//		Thread t1 = new Thread(r1);
//		Thread t2 = new Thread(r2);
//		Thread t3 = new Thread(r3);
		Thread t1 = new Thread(new R()); // r1~ 같이 만들지 않고 보통 이렇게 처리한다
		Thread t2 = new Thread(new R());
		Thread t3 = new Thread(new R());
		System.out.println("[main thread 시작]");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("[main thread 종료]");
	}
	
	/* Daemon 스레드 : main thread가 종료되면 작업 thread가 무조건 종료 된다 */
	public void test3() {
		T t1 = new T();
		System.out.println("[main thread 시작]");
		t1.setDaemon(true);
		t1.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[main thread 종료]");
	}
	
	/* join() : 작업 thread가 종료 되기 전에는 main thread가 종료 되지 않는다 */
	public void test4() {
		T t1 = new T();
		System.out.println("[main thread 시작]");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[main thread 종료]");
	}
	
	public static void main(String[] args) {
		new ThreadEx().test4();
	}

}

// 원래 하나의 파일에는 한 개의 클래스만 쓰지만 테스트를 위해 여러개의 클래스를 작성
class T extends Thread {
	
	public void run() {
		for(int i=0; i<200; i++) {
			System.out.print(this.getName() + " ");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	
}

class R implements Runnable {

	@Override
	public void run() {
		for(int i=1; i<=200; i++) {
			try {
				System.out.printf("%4d", i);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	
}









