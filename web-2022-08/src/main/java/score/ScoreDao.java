package score;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.MemberVo;
import mybatis.MyFactory;
import servlet.MybatisMemberFileUploadServlet;

public class ScoreDao {
	SqlSession sqlSession;
	ScorePageVo pVo;
	
	public ScoreDao() {
		sqlSession = MyFactory.getFactory().openSession();
	}
	
	public List<ScoreVo> select(ScorePageVo pVo) {
		List<ScoreVo> list = null;
		int totSize = sqlSession.selectOne("score.totSize", pVo.getFindStr());
		
		pVo.setTotSize(totSize);
		pVo.compute();
		this.pVo = pVo;
		
		list = sqlSession.selectList("score.select", pVo);
		
		sqlSession.close();
		return list;
	}
	
	public ScoreVo view(int serial) {
		ScoreVo sVo = null;
		sVo = sqlSession.selectOne("score.view", serial);
		
		sqlSession.close();
		return sVo;
	}
	
	public String insert(ScoreVo sVo) {
		String msg = "";
		int cnt = sqlSession.insert("score.insert", sVo);
		
		if(cnt > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
			msg = "저장 오류😢😢";
		}
		
		return msg;
	}
	
	public String update(ScoreVo sVo) {
		String msg = "";
		int cnt = sqlSession.delete("score.update", sVo); //resultType이 없으면 반환형이 int다.
		
		if(cnt > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
			msg = "수정 오류😢😢";
		}
		
		return msg;
	}
	
	public String delete(ScoreVo sVo) {
		String msg = "";
		int cnt = sqlSession.delete("score.delete", sVo.getSerial()); //resultType이 없으면 반환형이 int다.
		
		if(cnt > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
			msg = "삭제 오류😢😢";
		}
		
		return msg;
	}

	public ScorePageVo getpVo() { return pVo; }

}
