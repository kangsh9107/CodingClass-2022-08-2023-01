package lang;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTokenizerEx {

	public void test() {
		String source = "a/b/////d/e/f-adff,aefjaeg,eg/asa,,/3424----";
		
		// StringTokenizer
		StringTokenizer st = new StringTokenizer(source, "/-,");
		System.out.println("token size : " + st.countTokens());
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			System.out.println(s);
		}
		
		// split
		System.out.println("-".repeat(50));
		String[] arr = source.split("/|-|,");
		System.out.println("arr size : " + arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		StringTokenizerEx ste = new StringTokenizerEx();
		ste.test();
	}
	
}
