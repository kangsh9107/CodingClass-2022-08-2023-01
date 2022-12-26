package standard;

public class P221221 {

	public static void main(String[] args) {
		P221221 p = new P221221();
		
		String s1 = "try hello world";
		System.out.println(p.solution(s1));
		
		String s2 = "a  b ";
		System.out.println(p.solution(s2));
	}
	
	String solution(String s) {
		StringBuilder sb = new StringBuilder();
        String[] temp = s.split("");
        int index = 0;
        
        for(int i=0; i<temp.length; i++) {
            if(temp[i].equals(" ")) {
            	sb.append(" ");
            	index = 0;
            } else {
            	if(index%2 == 0) {
            		sb.append(temp[i].toUpperCase());
            		index++;
            	} else {
            		sb.append(temp[i].toLowerCase());
            		index++;
            	}
            }
        }
		
		return sb.toString();
	}
	
}
