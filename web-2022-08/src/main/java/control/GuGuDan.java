package control;

/* 생성자 안에서 2~9단 까지 출력 */
public class GuGuDan {
	
	public GuGuDan() {
		for(int i=2; i<=9; i++) {
			System.out.println(i + "단");
			for(int k=1; k<=9; k++) {
				System.out.printf("%d * %d = %2d\n", i, k, i*k);
			}
		}
	}
	
	public static void main(String[] args) {
		/* 익명 객체. 이름이 없어서 접근할 방법이 없다. */
		new GuGuDan();
	}
	
}
