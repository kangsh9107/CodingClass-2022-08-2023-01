package student;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/student.do")
public class StudentServlet extends HttpServlet {
	String path = "index.jsp?inc=student-exam/";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// view resolve
		System.out.println("get");
		
		Page pageVo = new Page();
		select(pageVo, req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String job = req.getParameter("job");
		System.out.println(job);
		
		switch(job) {
		case "select":
			Page pageVo = new Page();
			pageVo.setFindStr(req.getParameter("findStr"));
			pageVo.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
			select(pageVo, req, resp);
			break;
		}
	}
	
	public void select(Page pageVo, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao dao = new StudentDao();
		List<StudentVo> list = dao.select(pageVo);
		
		String url = path + "student_list_exam.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(url);
		req.setAttribute("list", list);
		req.setAttribute("pageVo", pageVo);
		
		rd.forward(req, resp);
	}

}
