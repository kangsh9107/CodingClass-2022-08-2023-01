package standard;

public class Caesar {

	public static void main(String[] args) {
		Caesar c = new Caesar();
		
		String s1 = "AB";
		int n1 = 1;
		System.out.println(c.solution(s1, n1));
		
//		String s2 = "z";
//		int n2 = 1;
//		System.out.println(c.solution(s2, n2));
//		
//		String s3 = "a B z";
//		int n3 = 4;
//		System.out.println(c.solution(s3, n3));
	}
	
	String solution(String s, int n) {
		String[] lc = {"a","b","c","d","e","f","g","h","i","j",
					   "k","l","m","n","o","p","q","r","s","t",
					   "u","v","w","x","y","z"};
		String[] uc = {"A","B","C","D","E","F","G","H","I","J",
					   "K","L","M","N","O","P","Q","R","S","T",
					   "U","V","W","X","Y","Z"};
		
		StringBuilder sb = new StringBuilder();
		int index = -1;
		int cnt = 0;
		String[] temp = s.split("");
		for(int i=0; i<temp.length; i++) {
			index = -1;
			cnt = 0;
			
			if(temp[i].equals(" ")) {
				sb.append(" ");
			} else {
				for(int j=0; j<lc.length; j++) {
					if(temp[i].equals(lc[j])) index = j;
				}
				
				if(index == -1) {
					for(int k=0; k<uc.length; k++) {
						if(temp[i].equals(uc[k])) {
							index = k;
							cnt++;
						}
					}
				}
				
				index += n;
				if(index > 25) index -= 26;
				
				if(cnt == 0) sb.append(lc[index]);
				else         sb.append(uc[index]);
			}
		}
		
		return sb.toString();
	}

}
