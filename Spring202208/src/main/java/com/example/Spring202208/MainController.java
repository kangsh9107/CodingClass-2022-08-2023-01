package com.example.Spring202208;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index"); //WEB-INF/view/index.jsp
		/* 
		 * WEB-INF에 있으면 단위 테스트가 불가능하다. 컨트롤러를 꼭 거쳐야한다.
		 * 예를들어 localhost:8282/WEB-INF/view/index.jsp는 오류가 난다. 외부에서 접근이 불가능하기 때문이다.
		 */
		
		return mv;
	}
}
