package com.example.Spring202208.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring202208.mybatis.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	BoardMapper mapper;
	
	public List<BoardVo> select(String findStr) {
//		System.out.println("BoardService1");
		List<BoardVo> list = mapper.select(findStr); //프로퍼티에 맵퍼 추가해야한다.
//		System.out.println("BoardService2");
		return list;
	}
}
