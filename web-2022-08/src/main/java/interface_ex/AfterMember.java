package interface_ex;

public class AfterMember implements MemberInterface {
	
	String name;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
}









