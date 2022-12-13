package dectest;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class MainServlet extends HttpServlet {

	RequestDispatcher rd;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		
		rd = req.getRequestDispatcher("dec_index.jsp");
		rd.forward(req, resp);
	}

}


/*
@WebServlet(urlPatterns = "/")
public class MainServlet extends HttpServlet {
	RequestDispatcher rd;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponses resp) throws ServletException, IOException {
		rd = req.getRequestDispatcher("dec_index.jsp");
		rd.forward(req, resp);
	}
}

1. @WebServlet 어노테이션, urlPatterns="/"
2. extends HttpServlet 상속
3. doGet 메소드 매개변수
4. rd.forward(req, resp);
*/