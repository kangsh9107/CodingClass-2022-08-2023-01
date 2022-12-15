package com.kang.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardMapper {
	public List<BoardVo> select(PageVo pVo);
	public List<BoardVo> board10();
	public int totList(PageVo pVo);
	
	public void hitUp(int sno);
	public BoardVo view(int sno);
	public List<AttVo> attList(int sno);
	
	public int attDeleteAll(int sno);
}
