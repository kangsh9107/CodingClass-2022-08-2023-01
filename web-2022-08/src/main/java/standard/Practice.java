package standard;

// 성씨로 오름차순 정렬하고 성씨가 같을 경우 국어 점수로 내림차순 하라
public class Practice {
	String name;
	int kor;
	
	public Practice(String name, int kor) {
		this.name = name;
		this.kor = kor;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	@Override
	public String toString() {
		return "이름:" + name + "국어점수:" + kor;
	}

	public static void main(String[] args) {
		
		Practice[] data = { new Practice("kim",100),
							new Practice("han",90),
							new Practice("jang",80),
							new Practice("kim",90) };
	}
}
