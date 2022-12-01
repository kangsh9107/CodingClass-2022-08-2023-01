package member;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyFactory;
import servlet.MemberFileUploadServlet;
import servlet.MybatisMemberFileUploadServlet;

public class MybatisMemberDao {
	SqlSession sqlSession;
	MybatisPageVo pVo;
	
	public MybatisMemberDao() {
		sqlSession = MyFactory.getFactory().openSession();
	}
	
	public String insert(MemberVo bVo) {
		String msg = "";
		int cnt = sqlSession.insert("member.insert", bVo);
		
		if(cnt > 0) {
			sqlSession.commit();
			msg = "저장 성공😀😀";
		} else {
			sqlSession.rollback();
			msg = "저장 오류😢😢";
		}
		
		//sqlSession.close();
		return msg;
	}
	
	public List<MemberVo> select(MybatisPageVo pVo) {
		//sqlSession = MyFactory.getFactory().openSession();
		List<MemberVo> list = null;
		
		//1) 검색어에 해당하는 데이터 개수(totSize)
		int totSize = sqlSession.selectOne("member.totSize", pVo.getFindStr());
		
		//2) page계산
		pVo.setTotSize(totSize);
		pVo.compute(); //MybatisPageVo에서 setTotSize 안에서 compute를 부르면 여기서 할 필요 없어진다. 이게 좀 더 캡슐화가 되고 서드파티 개발자를 배려하는 방법이다.
		this.pVo = pVo;
		
		//3) select
		list = sqlSession.selectList("member.select", pVo);
		
		sqlSession.close();
		return list;
	}
	
	public MemberVo view(String id) {
		MemberVo bVo = null;
		bVo = sqlSession.selectOne("member.view", id);
		
		sqlSession.close();
		return bVo;
	}
	
	public String delete(String id, String delFile) {
		String msg = "";
		int cnt = sqlSession.delete("member.delete", id); //resultType이 없으면 반환형이 int다.
		
		if(cnt > 0) {
			sqlSession.commit();
			File file = new File(MybatisMemberFileUploadServlet.path + delFile);
			if(file.exists()) file.delete();
			msg = "삭제 성공😀😀";
		} else {
			sqlSession.rollback();
			msg = "삭제 오류😢😢";
		}
		
		//delete 후 바로 select를 해야 하니까 sqlSession.close();를 바로 하면 안된다.
		return msg;
	}
	
	public String update(MemberVo bVo) {
		String msg = "";
		int cnt = sqlSession.update("update.update", bVo);

		if( !bVo.getSysFile().equals("") ) {
			File delFile = new File(MemberFileUploadServlet.path + bVo.getDelFile());
			
			if(delFile.exists()) delFile.delete();
		}
		
		if(cnt > 0) {
			sqlSession.commit();
			msg = "수정 성공😀😀";
		} else {
			sqlSession.rollback();
			msg = "수정 오류😢😢";
		}
		
		return msg;
	}

	public MybatisPageVo getpVo() { return pVo; }
	
}
