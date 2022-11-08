package student;

import java.io.IOException;
import java.io.PrintWriter;
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
	String path2 = "index.jsp?inc=student/";
	StudentDao dao;
	
	public StudentServlet() {
		dao = new StudentDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// view resolve
		//System.out.println("get");
		
		if(dao == null) dao = new StudentDao();
		
		Page pageVo = new Page();
		
		select(pageVo, req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(dao == null) dao = new StudentDao();
		
		String job = req.getParameter("job");
		//System.out.println(job);
		String url = "";
		RequestDispatcher rd = null;
		
		Page pageVo = new Page();
		pageVo.setFindStr(req.getParameter("findStr"));
		pageVo.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		req.setAttribute("pageVo", pageVo);
		
		switch(job) {
		case "select":
			select(pageVo, req, resp);
			break;
		case "insert":
			url = path2 + "student_input_form.jsp";
			rd = req.getRequestDispatcher(url);
			rd.forward(req, resp);
			break;
		case "insertR":
			StudentVo sVo = (StudentVo)req.getAttribute("sVo");
			if( insertR(sVo, resp) ) {
				select(pageVo, req, resp);
			} else {
				PrintWriter out = resp.getWriter(); // <% out.print() %>의 객체. 웹에 뭔가를 출력할 수 있다.
				out.print("<script>");
				out.print("    alert('저장 오류')");
				out.print("    history.back();");   // 입력폼으로(이전으로) 다시 보내준다.
				out.print("</script>");
			}
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
	
	public void select(Page pageVo, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(dao == null) dao = new StudentDao();
		
		List<StudentVo> list = dao.select(pageVo);
		//dao.close(); //insert에도 추가하면 인서트하고 셀렉트하면 렉이 걸리거나 꼬일 수 있다.
		// 컴퓨터 입장에서 커넥션을 열고 닫는건 긴 시간이기 때문이다.
		// 그래도 지금 dao에서 계속 열고 닫는건 비효율적이니 다른 방법을 쓰는게 좋다.
		
		// 1) 서블렛에 생성자를 추가하고, 생성자에서 dao 객체 생성.
		// 2) 각 처리 메서드에서 dao객체가 null인 경우에는 dao 객체를 생성하는 코드를 삽입.
		// 3) dao 각 메서드에 있는 close부분을 모두 삭제. (rs, ps, conn)
		// 4) public void close()를 추가하고 rs, ps, conn을 닫는 코드를 작성.
		
		String url = path + "student_list_exam.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(url);
		req.setAttribute("list", list);
		req.setAttribute("pageVo", pageVo);
		
		rd.forward(req, resp);
	}
	
	public boolean insertR(StudentVo sVo, HttpServletResponse resp) throws ServletException, IOException {
		if(dao == null) dao = new StudentDao();
		
		boolean b = dao.insert(sVo);
		
		return b;
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(dao == null) dao = new StudentDao();
		
		String url = path2 + "student_modify.jsp";
		String id = req.getParameter("id");
		StudentVo vo = dao.view(id);
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		req.setAttribute("vo", vo);
		
		Page pageVo = new Page();
		pageVo.setFindStr(req.getParameter("findStr"));
		pageVo.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		req.setAttribute("pageVo", pageVo);
		
		rd.forward(req, resp);
	}
	
	public void updateR(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(dao == null) dao = new StudentDao();
		
		StudentVo sVo = (StudentVo)req.getAttribute("sVo");
		Page pageVo = (Page)req.getAttribute("pageVo");
		
		boolean b = dao.modify(sVo);
		
		if(b) {
			select(pageVo, req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("    alert('수정 오류')");
			out.print("    history.back();");
			out.print("</script>");
		}
	}
	
	public void deleteR(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(dao == null) dao = new StudentDao();
		
		StudentVo sVo = (StudentVo)req.getAttribute("sVo");
		Page pageVo = (Page)req.getAttribute("pageVo");
		boolean b = dao.delete(sVo);
		
		if(b) {
			select(pageVo, req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("    alert('삭제 오류')");
			out.print("    history.back();");
			out.print("</script>");
		}
	}

}
