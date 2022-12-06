package board;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.SpaFactory;

public class BoardDao {
	SqlSession session;
	PageVo pVo;

	public BoardDao() {
		session = SpaFactory.getFactory().openSession();
	}

	public List<BoardVo> select(PageVo pVo) {
		List<BoardVo> list = null;

		// 페이지 정보를 재설정해 주기위한 작업
		int totSize = session.selectOne("board.totList", pVo);
		pVo.setTotSize(totSize);
		this.pVo = pVo;

		list = session.selectList("board.select", pVo);
		session.close();
		return list;
	}

	public synchronized boolean insert(BoardVo vo) {
		boolean b = true;

		int cnt = session.insert("board.insert", vo);
		if (cnt < 1) {
			b = false;
		} else if (vo.getAttList().size() > 0) {
			int attCnt = session.insert("board.attInsert", vo.getAttList());
			if (attCnt < 1)
				b = false;

		}

		if (b)
			session.commit();
		else
			session.rollback();
		session.close();

		return b;
	}

	public BoardVo view(int sno, String up) {
		BoardVo bVo = null;
		if (up != null && up.equals("up")) {// 상세보기인 경우만
			session.update("board.hitUp", sno);
			session.commit();
		}
		bVo = session.selectOne("board.view", sno);
		List<AttVo> attList = session.selectList("board.attList", sno);
		bVo.setAttList(attList);

		session.close();
		return bVo;
	}

	public boolean update(BoardVo bVo, String[] delFiles) {
		boolean b = true;
		int cnt = session.update("board.update", bVo);
		if (cnt < 1) {
			b = false;
		} else if (bVo.getAttList().size() > 0) {
			int attCnt = session.insert("board.attUpdate", bVo);
			if (attCnt < 1)
				b = false;
		}

		if (b) {
			if (delFiles.length > 0) {
				// 첨부 파일 데이터 삭제
				cnt = session.delete("board.attDelete", delFiles);
				if (cnt > 0) {
					fileDelete(delFiles); // 파일 삭제
				} else {
					b = false;
				}
			}
		}
		if (b)
			session.commit();
		else
			session.rollback();

		session.close();

		return b;
	}

	public void fileDelete(String[] delFiles) {
		for (String f : delFiles) {
			File file = new File(FileUploadServlet.uploadPath + f);
			if (file.exists())
				file.delete();
		}
	}

	public boolean delete(BoardVo bVo) {
		boolean b = true;

		// 자신의 글에 댓글이 있는지 판단하기
		// 같은 grp안에 자신의 seq보다 1더 큰 seq의 자료에서
		// deep이 자신 보다 큰것이 있으면 댓글이 있는 것임.
		int replCnt = session.selectOne("board.replCheck", bVo);

		if (replCnt > 0) {
			b = false;
			return b;
		}

		// sno에 해당하는 테이블 삭제
		int cnt = session.delete("board.delete", bVo);

		if (cnt < 1) {
			b = false;
		} else {
			// sno를 pSno로 바꾸어 첨부 테이블에서 첨부파일 목록 가져오기
			List<String> attList = session.selectList("board.delFileList", bVo.getSno());

			// 첨부 테이블 삭제
			if (attList.size() > 0) {
				cnt = session.delete("board.attDeleteAll", bVo.getSno());
				if (cnt > 0) {
					// 첨부 파일 삭제
					if (attList.size() > 0) {
						String[] delList = attList.toArray(new String[0]);
						fileDelete(delList);
					}
				} else {
					b = false;
				}
			}

		}

		if (b)
			session.commit();
		else
			session.rollback();

		session.close();
		return b;
	}

	/*
	 * 본문글 쓰고 있을때 리플을 달면 serial에 오류가 생길 수 있어서 동시에 처리되지 않고 순서대로 처리되도록
	 * 
	 * 멀티스레드 환경에서 스레드간 동기화가 되어있지 않으면 data의 안전성과 신뢰성에 문제가 생길 수 있다.
	 */
	public synchronized boolean repl(BoardVo bVo) {
		boolean b = true;
		session.update("board.seqUp", bVo);
		int cnt = session.insert("board.repl", bVo);
		if (cnt < 1) {
			b = false;
		} else if (bVo.getAttList().size() > 0) {
			int attCnt = session.insert("board.attInsert", bVo.getAttList());
			if (attCnt < 1)
				b = false;
		}

		if (b)
			session.commit();
		else
			session.rollback();
		session.close();

		return b;
	}

	public PageVo getpVo() {
		return pVo;
	}

}
