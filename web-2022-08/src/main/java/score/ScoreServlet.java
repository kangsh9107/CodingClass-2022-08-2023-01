package score;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberVo;
import member.MybatisMemberDao;

@WebServlet(urlPatterns = {"/score.do"})
public class ScoreServlet extends HttpServlet {
	RequestDispatcher rd;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ScorePageVo pVo = new ScorePageVo();
		req.setAttribute("pVo", pVo);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getParameter("job")) {
		case "select":
			select(req, resp);
			break;
		case "view":
			view(req, resp);
			break;
		case "insert":
			insert(req, resp);
			break;
		case "insertR":
			insertR(req, resp);
			break;
		case "update":
			update(req, resp);
			break;
		case "updateR":
			updateR(req, resp);
			break;
		case "deleteR":
			deleteR(req, resp);
			break;
		}
	}

	public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ScorePageVo pVo = (ScorePageVo)req.getAttribute("pVo");
		ScoreDao dao = new ScoreDao();
		List<ScoreVo> list = dao.select(pVo);
		
		req.setAttribute("pVo", pVo);
		req.setAttribute("list", list);
		rd = req.getRequestDispatcher("mybatisScore/score_select.jsp");
		rd.include(req, resp);
	}
	
	public void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int serial = Integer.parseInt(req.getParameter("serial"));
		ScoreDao dao = new ScoreDao();
		ScoreVo sVo = dao.view(serial);
		
		req.setAttribute("sVo", sVo);
		rd = req.getRequestDispatcher("mybatisScore/score_view.jsp");
		rd.include(req, resp);
	}
	
	public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rd = req.getRequestDispatcher("mybatisScore/score_insert.jsp");
		rd.include(req, resp);
	}
	
	public void insertR(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ScorePageVo pVo = (ScorePageVo)req.getAttribute("pVo");
		ScoreVo sVo = (ScoreVo)req.getAttribute("sVo");
		
		ScoreDao dao = new ScoreDao();
		String msg = dao.insert(sVo);
		List<ScoreVo> list = dao.select(pVo);
		
		if( !msg.equals("") ) {
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("    alert('" + msg + "')");
			out.print("</script>");
		}
		
		req.setAttribute("pVo", pVo);
		req.setAttribute("list", list);
		rd = req.getRequestDispatcher("mybatisScore/score_select.jsp");
		rd.include(req, resp);
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rd = req.getRequestDispatcher("mybatisScore/score_update.jsp");
		rd.include(req, resp);
	}
	
	public void updateR(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ScorePageVo pVo = (ScorePageVo)req.getAttribute("pVo");
		ScoreVo sVo = (ScoreVo)req.getAttribute("sVo");
		
		ScoreDao dao = new ScoreDao();
		String msg = dao.update(sVo);
		List<ScoreVo> list = dao.select(pVo);
		
		if( !msg.equals("") ) {
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("    alert('" + msg + "')");
			out.print("</script>");
		}
		
		req.setAttribute("pVo", pVo);
		req.setAttribute("list", list);
		rd = req.getRequestDispatcher("mybatisScore/score_select.jsp");
		rd.include(req, resp);
	}
	
	public void deleteR(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ScorePageVo pVo = (ScorePageVo)req.getAttribute("pVo");
		ScoreVo sVo = (ScoreVo)req.getAttribute("sVo");
		
		ScoreDao dao = new ScoreDao();
		String msg = dao.delete(sVo);
		List<ScoreVo> list = dao.select(pVo);
		
		if( !msg.equals("") ) {
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("    alert('" + msg + "')");
			out.print("</script>");
		}
		
		req.setAttribute("pVo", pVo);
		req.setAttribute("list", list);
		rd = req.getRequestDispatcher("mybatisScore/score_select.jsp");
		rd.include(req, resp);
	}
	
}
