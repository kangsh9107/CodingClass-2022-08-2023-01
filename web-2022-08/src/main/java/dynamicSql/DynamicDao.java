package dynamicSql;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyFactory2;

public class DynamicDao {
	SqlSession sqlSession;
	EmployeesVo eVo;
	List<EmployeesVo> list;
	
	public DynamicDao() {
		sqlSession = MyFactory2.getFactory().openSession();
		eVo = null;
		list = null;
	}
	
	public void ifTest() {
		eVo = new EmployeesVo();
		//eVo.setLastName("Murphy");
		list = sqlSession.selectList("dynamic.ifTest", eVo.getLastName());
		String r = "";
		for(EmployeesVo item : list) {
			eVo.setEmployeeNumber(item.getEmployeeNumber());
			eVo.setLastName(item.getLastName());
			eVo.setFirstName(item.getFirstName());
			eVo.setExtension(item.getExtension());
			eVo.setEmail(item.getEmail());
			eVo.setOfficeCode(item.getOfficeCode());
			eVo.setReportsTo(item.getReportsTo());
			eVo.setJobTitle(item.getJobTitle());
			
			r += String.format(
					  "employeeNumber: %s\t lastName: %s\t"
					+ "firstName: %s\t extension: %s\t"
					+ "email: %s\t officeCode: %d\t"
					+ "reportsTo: %d\t jobTitle: %s\n"
					, eVo.getEmployeeNumber(), eVo.getLastName()
					, eVo.getFirstName(), eVo.getExtension()
					, eVo.getEmail(), eVo.getOfficeCode()
					, eVo.getReportsTo(), eVo.getJobTitle()
			);
		}
		
		System.out.println(r);
		
		eVo = null;
		sqlSession.close();
	}
	
	public void chooseTest() {
		eVo = new EmployeesVo();
		//eVo.setOfficeCode(1);
		eVo.setOfficeCode(2);
		list = sqlSession.selectList("dynamic.chooseTest", eVo.getOfficeCode());
		String r = "";
		for(EmployeesVo item : list) {
			eVo.setEmployeeNumber(item.getEmployeeNumber());
			eVo.setLastName(item.getLastName());
			eVo.setEmail(item.getEmail());
			
			System.out.println(eVo.getEmployeeNumber());
			System.out.println(eVo.getLastName());
			if(eVo.getOfficeCode() == 2) System.out.println(eVo.getEmail());
		}
		
		System.out.println(r);
		
		eVo = null;
		sqlSession.close();
	}
	
	public void whereTest() {
		
	}
	
	public void setTest() {
		
	}
	
	public void forEachTest() {
		eVo = new EmployeesVo();
		int[] arr = {1, 2, 3};
		list = sqlSession.selectList("dynamic.forEachTest", arr);
		String r = "";
		for(EmployeesVo item : list) {
			eVo.setEmployeeNumber(item.getEmployeeNumber());
			eVo.setLastName(item.getLastName());
			eVo.setFirstName(item.getFirstName());
			eVo.setExtension(item.getExtension());
			eVo.setEmail(item.getEmail());
			eVo.setOfficeCode(item.getOfficeCode());
			eVo.setReportsTo(item.getReportsTo());
			eVo.setJobTitle(item.getJobTitle());
			
			r += String.format(
					  "employeeNumber: %s\t lastName: %s\t"
					+ "email: %s\t officeCode: %d\t\n"
					, eVo.getEmployeeNumber(), eVo.getLastName()
					, eVo.getEmail(), eVo.getOfficeCode()
			);
		}
		
		System.out.println(r);
		
		eVo = null;
		sqlSession.close();
	}
	
	public void mapTest() {
		
	}
	
	public static void main(String[] args) {
		DynamicDao dao = new DynamicDao();
		//dao.ifTest();
		//dao.chooseTest();
		dao.forEachTest();
	}

}
