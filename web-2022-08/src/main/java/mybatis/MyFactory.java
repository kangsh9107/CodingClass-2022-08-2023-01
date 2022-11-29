package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyFactory {
	
	private static SqlSessionFactory factory;
	static {
		try {
			Reader r =  Resources.getResourceAsReader("mybatis/config.xml"); //경로를 적지 않으면 WEB-INF>classes>config.xml
			factory = new SqlSessionFactoryBuilder().build(r);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static SqlSessionFactory getFactory() { return factory; }
	
	/*
	 * public static void main(String[] args) { //session 객체를 통해 CRUD를 실제 실행
	 * SqlSession session = MyFactory.getFactory().openSession();
	 * 
	 * if(session == null) { System.out.println("factory 생성 오류"); } else {
	 * System.out.println("factory 생성"); } }
	 */

}
