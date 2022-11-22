package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import org.json.simple.JSONArray;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import member.MemberDao;

@WebServlet(urlPatterns = {"/memberServlet.do"})
public class MemberServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String job = req.getParameter("job");
		
		switch(job) {
		case "select":
			select(req, resp);
			break;
		}
	}
	
	public void select(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String findStr = req.getParameter("findStr");
		MemberDao dao = new MemberDao();
		JSONArray array = dao.select(findStr);
		
		PrintWriter out = resp.getWriter();
		out.print(array.toJSONString()); // js/member_control.js의 list 함수의 xhr.responseText 로 날아간다.
	}

}









