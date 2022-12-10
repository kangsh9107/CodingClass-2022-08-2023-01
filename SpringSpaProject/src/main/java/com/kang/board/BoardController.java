package com.kang.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/board/board_select")
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();
		List<BoardVo> list = service.select("1");
		
		mv.addObject("list", list);
		mv.setViewName("board/board_select");
		return mv;
	}

}
