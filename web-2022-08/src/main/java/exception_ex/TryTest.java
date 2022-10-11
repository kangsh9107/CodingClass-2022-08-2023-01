package exception_ex;

public class TryTest {
	
	TryTest() {
		
	}
	
	int a() {
		String s = "123";
		try {
			int i = Integer.parseInt(s);
		} catch(Exception ex) {
			System.out.println("숫자가 아니에요.");
		} finally {
			System.out.println("예외 만나던 안만나던 무조건 실행.");
		}
		return 10;
	}
	
	void b() {
		String[] arr = {"a","b","c"};
		for(int i=0; i<=3; i++) {
			try {
				System.out.println(arr[i]);
			} catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("배열의 크기를 벗어난듯...");
			}
		}
	}
	
	void c() {
		int x, y;
		try {
			x = 20;
			y = x / 0;
		} catch(ArithmeticException ex) {
			System.out.println("연산식에 오류가 있습니다.");
		}
	}
	
	void d() {
		try {
			throw new Exception("무조건");
//			System.out.println("실행되지 않음"); // 44에서 무조건 예외 발생.
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	void e() {
		String name = null;
		try {
			System.out.println(name.equals("abc"));
		} catch(Exception ex) {
			System.out.println("비교가 불가능 합니다.");
		}
	}
	
	void test() {
		int xx = 20;
		int yy = 0;
		System.out.println(xx/yy);
	}
	
	public static void main(String[] args) {
		try {
			new TryTest().test();			
		} catch(Exception ex) {
			System.out.println("오류발생");
		}
	}
	
}









