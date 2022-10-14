package standard;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class P221014 {
	public static void main(String[] args) {
		String s = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String test = "hipwg@naver.com";
		boolean b = Pattern.matches(s, test);
		System.out.print(b);
		
		List<Integer> li = new ArrayList<>();
	}
}
