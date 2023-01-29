package standard;

public class SecretMap {
	
	public static void main(String[] args) {
		SecretMap sm = new SecretMap();
		
		int n1 = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		System.out.println(sm.solution(n1, arr1, arr2));
		
//		int n2 = 6;
//		int[] arr3 = {46, 33, 33, 22, 31, 50};
//		int[] arr4 = {27, 56, 19, 14, 14, 10};
//		System.out.println(sm.solution(n2, arr3, arr4));
	}
	
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		String wall1 = "";
		String wall2 = "";
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			wall1 = String.valueOf(Integer.toString(arr1[i], 2));
			if(wall1.length() < n) {
				int length = n -  wall1.length();
				for(int j=0; j<length; j++) {
					wall1 = "0" + wall1;
				}
			}
			wall2 = String.valueOf(Integer.toString(arr2[i], 2));
			if(wall2.length() < n) {
				int length = n - wall2.length();
				for(int k=0; k<length; k++) {
					wall2 = "0" + wall2;
				}
			}
			
			for(int u=0; u<n; u++) {
				String[] temp1 = wall1.split("");
				String[] temp2 = wall2.split("");
				if(temp1[u].equals("1") || temp2[u].equals("1")) {
					sb.append("#");
				} else {
					sb.append(" ");
				}
			}
			
			answer[i] = sb.toString();
			sb.setLength(0);
		}
		
		return answer;
	}

}
