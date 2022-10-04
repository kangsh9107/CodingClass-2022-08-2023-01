package array;

public class ArrayDeclare {

	ArrayDeclare() {
		/* 크기를 지정하여 배열 선언 */
//		int[] a = new int[5];
//		String[] s = new String[5];
//		byte[] b = new byte[1024];
//		Object[] obj = new Object[5];
		
		/* 배열만 선언하고 크기를 나중에 지정 */
//		int[] aa;
//		aa = new int[5];
//		String[] ss;
//		ss = new String[3];
//		byte[] bb;
//		bb = new byte[512];
//		Object[] obj2;
//		obj2 = new Object[2];
		
		/* 초기값을 사용하여 배열 선언 */
		int[] aaa = {1,2,3,4,5};
		byte[] bbb = new byte[] {'a','b','c','d','e'};
		String[] sss = {"홍길동", "일지매", "임꺽정"};
		
		/* 첨자를 사용하여 배열 접근 */
		System.out.println( aaa[0] );
		System.out.println( bbb[1] );
		System.out.println( sss[2] );
		
		/* 객체형 배열 사용하기 */
		Data[] d = new Data[5]; // heap m에 주소 안에 null 5개.
		// d[0].name = "kim"; // 그래서 NullPointer Exception.
		
		// 이렇게 해야 null이 있는 곳에서 abc가 들어간 주소 가리키면서 작동.
		Data abc = new Data();
		abc.name = "kim";
		d[0] = abc;
		System.out.println(d[0].name);
	}
	
	public static void main(String[] args) {
		new ArrayDeclare();
	}
	
}
