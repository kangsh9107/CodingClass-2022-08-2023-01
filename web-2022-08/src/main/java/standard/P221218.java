package standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P221218 {

	public static void main(String[] args) {
//		String[] babbling = {"aya", "yee", "u", "maa"};
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		int answer = 0;
		
		for(String b : babbling) {
			if(b.length() <= 1) {
				continue;
			} else if(b.length() == 2) {
				if(b.equals("ye") || b.equals("ma")) answer++;
				continue;
			} else if(b.length() == 3) {
				if(b.equals("aya") || b.equals("woo")) answer++;
				continue;
			} else if(b.length() == 4) {
				if(b.equals("maye") || b.equals("yema")) answer++;
				continue;
			} else if(b.contains("b")   || b.contains("c")   ||
					  b.contains("d")   || b.contains("f")   ||
					  b.contains("g")   || b.contains("h")   ||
					  b.contains("i")   || b.contains("j")   ||
					  b.contains("k")   || b.contains("l")   ||
					  b.contains("n")   || b.contains("p")   ||
					  b.contains("s")   || b.contains("t")   ||
					  b.contains("u")   || b.contains("v")   ||
					  b.contains("x")   || b.contains("z")   ||
					  b.contains("aa")  || b.contains("yy")  ||
					  b.contains("ee")  || b.contains("ww")  ||
					  b.contains("mm")  || b.contains("ooo") ||
					  b.contains("ey")  || b.contains("mam") ||
					  b.contains("ow")  || b.contains("ae")  ||
					  b.contains("ao")  || b.contains("yw")  ||
					  b.contains("yo")  || b.contains("ym")  ||
					  b.contains("eo")  || b.contains("wy")  ||
					  b.contains("wa")  || b.contains("wy")  ||
					  b.contains("wm")  || b.contains("oe")  ||
					  b.contains("my")  || b.contains("me")  ||
					  b.contains("mw")  || b.contains("mo")) {
				continue;
			} else if(b.length() >= 5) {
				List<String> list = new ArrayList<>(Arrays.asList(b.split("")));
				int cnt = 0;
				
				for(int i=0; i<list.size();) {
					if(list.get(i).equals("y") && list.get(i+1).equals("e")) {
						list.remove(i);
						list.remove(i);
					} else if(list.get(i).equals("m") && list.get(i+1).equals("a")) {
						list.remove(i);
						list.remove(i);
					} else if(list.get(i).equals("a") && list.get(i+1).equals("y") && list.get(i+2).equals("a")) {
						list.remove(i);
						list.remove(i);
						list.remove(i);
					} else if(list.get(i).equals("w") && list.get(i+1).equals("o") && list.get(i+2).equals("o")) {
						list.remove(i);
						list.remove(i);
						list.remove(i);
					}
					
					cnt++;
					if(cnt > 50) break;
				}
				
				if(list.size() == 0) answer++;
			}
		}
		
		System.out.println(answer);
	}

}
