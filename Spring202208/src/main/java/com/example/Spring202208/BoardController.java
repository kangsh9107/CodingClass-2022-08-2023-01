package com.example.Spring202208;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Spring202208.board.BoardService;
import com.example.Spring202208.board.BoardVo;

@RestController
public class BoardController {
	
	/* mybatis를 사용하지 않을 때 */
//	JdbcTemplate jdbcTemp;
//	
//	@Autowired
//	public BoardController(JdbcTemplate temp) {
//		this.jdbcTemp = temp;
//	}
//	
//	@RequestMapping("/board/board_select")
//	public ModelAndView select() {
//		ModelAndView mv = new ModelAndView();
//		List<String> subjects = new ArrayList<>();
//		
//		try {
//			Connection conn = jdbcTemp.getDataSource().getConnection();
//			
//			String sql = "select subject from board";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				subjects.add(rs.getString("subject"));
//			}
//			
//			rs.close();
//			ps.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		mv.addObject("subjects", subjects);
//		mv.setViewName("board/board_select");  //WEB-INF/view/board/board_select.jsp
//		return mv;
//	}
	
	/* mybatis를 사용할 때 */
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
