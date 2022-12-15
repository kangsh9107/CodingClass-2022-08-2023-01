package com.kang.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardService {
	
	PageVo pVo;
	
	@Autowired
	BoardMapper mapper;
	
	@Autowired
	PlatformTransactionManager manager;
	
	TransactionStatus status;
	
	public List<BoardVo> select(PageVo pVo) {
		int totSize = mapper.totList(pVo);
		pVo.setTotSize(totSize);
		this.pVo = pVo;
		List<BoardVo> list = mapper.select(pVo);
		return list;
	}
	
	public List<BoardVo> board10() {
		List<BoardVo> list = mapper.board10();
		return list;
	}
	
	public BoardVo view(PageVo pVo, BoardVo bVo, String up) {
		//수정 후 상세보기 페이지가 다시 나왔을 때 조회수가 오르지 않게
		if(up != null && up.equals("up")) {
			mapper.hitUp(pVo.getSno());
		}
		
		bVo = mapper.view(pVo.getSno());
		bVo.setAttList(mapper.attList(pVo.getSno()));
//		List<AttVo> attList = mapper.attList(pVo.getSno());
//		bVo.setAttList(attList);
		
		return bVo;
	}

	public PageVo getpVo() { return pVo; }

}
