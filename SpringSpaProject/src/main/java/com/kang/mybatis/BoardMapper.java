package com.kang.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kang.board.BoardVo;

@Repository
@Mapper
public interface BoardMapper {
	public List<BoardVo> select(String findStr);
}
