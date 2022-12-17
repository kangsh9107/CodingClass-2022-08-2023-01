package standard;

public class Babbling {

	public static void main(String[] args) {
//		String[] babbling = {"aya", "yee", "u", "maa"};
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		int answer = 0;
		
		for(String b : babbling) {
			if(b.length() <= 1) {
				continue;
			} else if(b.length() == 2 && b.equals("ye")) {
				answer++;
			} else if(b.length() == 2 && b.equals("ma")) {
				answer++;
			} else if(b.length() == 3 && b.equals("aya")) {
				answer++;
			} else if(b.length() == 3 && b.equals("woo")) {
				answer++;
			} else if(b.length() == 4 && b.equals("maye") || b.equals("yema")) {
				answer++;
			} else if(b.contains("b")   || b.contains("c")    ||
					  b.contains("d")   || b.contains("f")    ||
					  b.contains("g")   || b.contains("h")    ||
					  b.contains("i")   || b.contains("j")    ||
					  b.contains("k")   || b.contains("l")    ||
					  b.contains("n")   || b.contains("p")    ||
					  b.contains("s")   || b.contains("t")    ||
					  b.contains("u")   || b.contains("v")    ||
					  b.contains("x")   || b.contains("z")    ||
					  b.contains("aa")  || b.contains("yy")   ||
					  b.contains("ee")  || b.contains("ww")   ||
					  b.contains("mm")  || b.contains("ooo")  ||
					  b.contains("yey") || b.contains("woow") ||
					  b.contains("mam") || b.contains("ae")   ||
					  b.contains("ao")  || b.contains("yw")   ||
					  b.contains("yo")  || b.contains("ym")   ||
					  b.contains("eo")  || b.contains("wa")   ||
					  b.contains("wy")  || b.contains("wm")   ||
					  b.contains("oe")  || b.contains("me")   ||
					  b.contains("mw")  || b.contains("mo")   ||
					  b.contains("wow")) {
				continue;
			} else if(b.length() > 4) {
				while(b.length() > 4) {
					String[] chk = b.split("");
					
					for(int i=0; i<chk.length-2; i++) {
						if(chk[i].equals("a") && chk[i+1].equals("y") && chk[i+2].equals("a")) {
							answer++;
							b.substring(i, i+3);
							break;
						} else if(chk[i].equals("y") && chk[i].equals("e")) {
							answer++;
							b.substring(i, i+2);
							break;
						} else if(chk[i].equals("w") && chk[i+1].equals("o") && chk[i+2].equals("o")) {
							answer++;
							b.substring(i, i+3);
						} else if(chk[i].equals("m") && chk[i].equals("a")) {
							answer++;
							b.substring(i, i+2);
							break;
						}
					}
					
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

}
