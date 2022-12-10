package com.kang.guestbook;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GuestbookController {

	@RequestMapping("/guestbook/guestbook_select")
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();
		List<GuestbookVo> list = null;
		
		mv.addObject("list", list);
		mv.setViewName("guestbook/guestbook_select");
		return mv;
	}
	
}
