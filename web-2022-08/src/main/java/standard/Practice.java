package standard;

public class Practice {
	
	public static void main(String[] args) {
//		System.out.println("    *");
//		System.out.println("   ***");
//		System.out.println("  *****");
//		System.out.println(" *******");
//		System.out.println("*********");
		
		String str1 = "";
		String str2 = "";
		for(int i=0; i<10; i++) {
			if(i==0)      str1 = "    ";
			else if(i==2) str1 = "   ";
			else if(i==4) str1 = "  ";
			else if(i==6) str1 = " ";
			else          str1 = "";
			str2 += "*";
			if(i%2==0) System.out.println(str1 + str2);
		}
	}
	
}
