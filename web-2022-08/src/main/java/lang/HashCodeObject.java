package lang;

public class HashCodeObject {
	
	int id;
	
	public HashCodeObject(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	public static void main(String[] args) {
		
		/* hashCode()를 재정의 하기 전 */
		/*
		HashCodeObject o1 = new HashCodeObject();
		HashCodeObject o2 = new HashCodeObject();
		
		System.out.println(o1 == o2);
		System.out.println(o1.equals(o2));
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		*/
		
		/* hashCode()를 재정의 한 후 */
		HashCodeObject o3 = new HashCodeObject(100);
		HashCodeObject o4 = new HashCodeObject(100);
		
		System.out.println(o3 == o4);
		System.out.println(o3.equals(o4));
		System.out.println(o3.hashCode());
		System.out.println(o4.hashCode());
	}
	
}
