package com.kang.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardMapper {
	public List<BoardVo> select(String findStr);
}
