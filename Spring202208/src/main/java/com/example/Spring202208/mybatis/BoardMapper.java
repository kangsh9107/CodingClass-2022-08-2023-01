//mapper.xml의 경로
package com.example.Spring202208.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.Spring202208.board.BoardVo;

@Repository
@Mapper
public interface BoardMapper {
	public List<BoardVo> select(String findStr);
}
