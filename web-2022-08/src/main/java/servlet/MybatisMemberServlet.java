package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberVo;
import member.MybatisMemberDao;
import member.MybatisPageVo;

@WebServlet(urlPatterns = {"/mms.do"})
public class MybatisMemberServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MybatisPageVo pVo = new MybatisPageVo();
		req.setAttribute("pVo", pVo);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String job = req.getParameter("job");
		if(job == null) job = "";
		
		switch(job) {
		case "":
		case "select":
			select(req, resp);
			break;
		case "view":
			view(req, resp);
			break;
		case "insert":
			insert(req, resp);
			break;
		case "delete":
			delete(req, resp);
			break;
		}
	}
	
	public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MybatisPageVo pVo = (MybatisPageVo)req.getAttribute("pVo");
		MybatisMemberDao dao = new MybatisMemberDao();
		List<MemberVo> list = dao.select(pVo);
		//pVo = dao.getpVo();
		
		req.setAttribute("pVo", pVo);
		req.setAttribute("list", list);
		RequestDispatcher rd = req.getRequestDispatcher("mybatis/member_select.jsp");
		rd.include(req, resp);
	}
	
	public void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MybatisMemberDao dao = new MybatisMemberDao();
		MemberVo bVo = dao.view(id);
		
		req.setAttribute("bVo", bVo);
		RequestDispatcher rd = req.getRequestDispatcher("mybatis/member_view.jsp");
		rd.include(req, resp);
	}
	
	public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("mybatis/member_insert.jsp");
		rd.include(req, resp);
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String delFile = req.getParameter("delFile");
		MybatisMemberDao dao = new MybatisMemberDao();
		String msg = dao.delete(id, delFile);
		
		MybatisPageVo pVo = (MybatisPageVo)req.getAttribute("pVo");
		List<MemberVo> list = dao.select(pVo);
		
		req.setAttribute("pVo", pVo);
		req.setAttribute("list", list);
		RequestDispatcher rd = req.getRequestDispatcher("mybatis/member_select.jsp");
		rd.include(req, resp);
	}
	
}
