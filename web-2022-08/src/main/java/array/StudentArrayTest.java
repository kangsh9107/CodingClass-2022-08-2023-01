package array;

public class StudentArrayTest {
	void arrayTest() {
		String[] name   = {"kim" , "lee" , "park", "choi", "nam",
						   "hong", "jang", "na"  , "kang", "han"};
		int[]    score  = {55 , 66, 77, 88, 99,
						   100, 50, 70, 80, 90};
		double[] weight = {88, 99, 77, 66 , 55,
						   56, 78, 98, 100, 48};
		
		// 1) 배열 선언
		Student[] std = new Student[10];
		
		// 2) 배열 안에 student 객체를 생성 후 대입
		// std[0].name = name[0]; // NullPointer Exception
		for(int i=0; i<std.length; i++) {
			std[i] = new Student(name[i], score[i], weight[i]);
		}
		
		for(int i=0; i<std.length; i++) {
			System.out.println(std[i]);
			System.out.println("-".repeat(10));
		}
		
		// park씨의 성적과 몸무게를 각각 100,70으로 수정
		int k = -1; // 검색된 위치
		for(int i=0; i<std.length; i++) {
			if(std[i].name.equals("hong")) {
				k = i;
				break;
			}
		}
		
		if(k>-1) {	
			System.out.println("수정 전 : ");
			System.out.println(std[k]);
			std[k].score = 100;
			std[k].weight = 70;
			System.out.println("수정 후 : ");
			System.out.println(std[k]);
		} else {
			System.out.println("찾는 데이터가 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		StudentArrayTest st = new StudentArrayTest();
		st.arrayTest();
	}
}









