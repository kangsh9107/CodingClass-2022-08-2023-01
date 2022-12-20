package standard;

public class StrangeString {

	public static void main(String[] args) {
		StrangeString ss = new StrangeString();
		
		String s1 = "try hello world";
		System.out.println(ss.solution(s1));
		
		String s2 = "a";
		System.out.println(ss.solution(s2));
	}
	
	String solution(String s) {
		StringBuilder sb = new StringBuilder();
        String[] temp1 = s.split(" ");
        String[] temp2 = null;
        
        for(int i=0; i<temp1.length; i++) {
            temp2 = temp1[i].split("");
            
            for(int j=0; j<temp2.length; j++) {
                if(j%2 == 0) {
                    sb.append(temp2[j].toUpperCase());
                } else {
                    sb.append(temp2[j].toLowerCase());
                }
            }
            
            sb.append(" ");
        }
		
		return sb.toString().substring(0, sb.length()-1);
	}

}
