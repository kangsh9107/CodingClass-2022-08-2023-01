package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/sbs.kr", "/servlet/mbc.kr"}) // 3) 호출경로 지정
public class TestServlet extends HttpServlet {  // 1) HttpServlet 상속

	@Override                                   // 2) 사용할 메서드 재정의. req = request, resp = response
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String phone = req.getParameter("phone");
		
		System.out.println("get으로 호출");
		System.out.println("id: " + id + ", phone: " + phone);
		
		// 결과 전송
		RequestDispatcher rd = req.getRequestDispatcher("test_servlet.jsp");
		//rd.forward(req, resp);
		rd.include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String phone = req.getParameter("phone");
		
		System.out.println("post로 호출");
		System.out.println("id: " + id + ", phone: " + phone);
		
		RequestDispatcher rd = req.getRequestDispatcher("../index.jsp");
		//rd.forward(req, resp);
		rd.include(req, resp);
	}

	/*
	    // include, forward
		공통점
		RequestDispatcher 객체에서 사용되는 메소드이다.
		요청 전달에 사용되는 메소드이다.
		다른 페이지에 객체를 전달할 수 있다.
		
		
		차이점
		클라이언트에게 요청받은 request를 유지한다는 점에서는 같지만
		request의 제어권에서 차이가 있다.
		
		Forward의 경우 URL1에서 URL2로 전달할 경우 제어권이 URL2로 넘어가게되고
		따라서 URL1에서 처리한 결과화면이 클라이언트에게 보여지지 않고 URL2의 결과만
		뿌려지게 된다.
		
		Include는 URL1에서 URL2로 전달하고 제어권은 다시 URL1으로 돌아오게 된다.
		따라서 URL2의 화면이 URL1에 포함되서 보여지게 된다.
	 */
}
