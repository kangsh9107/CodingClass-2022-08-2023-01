package standard;

// 성씨로 오름차순 정렬하고 성씨가 같을 경우 국어 점수로 내림차순 하라
public class Practice {
	
	public static void main(String[] args) {
		int b = 385;
		int b10 = (b-(b/100)*100)/10;
		System.out.println(b10); // 8
		
		System.out.println("-".repeat(50));
		// --------------------------------------------------
		
        int A = 2;
        
        for(int i=A; i==A; i++) {
        	for(int k=1; k<=9; k++) {
        		System.out.printf("%d * %d = %d\n", i, k, i*k);
        	}
        }
	}
	
}
