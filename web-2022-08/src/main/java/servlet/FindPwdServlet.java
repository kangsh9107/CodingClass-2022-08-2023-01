package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import findpwd.FindPwdDao;
import findpwd.FindPwdVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import security.AES;

@WebServlet(urlPatterns = "/FindPwd.do")
public class FindPwdServlet extends HttpServlet {
	String path = "index.jsp?inc=member/";
	String url  = "";
	RequestDispatcher rd = null;
	FindPwdDao dao = null;
	
	String host = "smtp.naver.com";
	String uploadPath = "C:\\Users\\K\\eclipse-workspace\\web-2022-08\\src\\main\\webapp\\upload\\";
	
	public FindPwdServlet() {
		dao = new FindPwdDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		url = path + "find_pwd.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sender = req.getParameter("sender");
		String receiver = req.getParameter("receiver");
		String subject = req.getParameter("subject");
		String content = "";
		
		if(dao == null) dao = new FindPwdDao();
		
		try {
			// 메일 관련 자료 캡슐화
			Properties prop = new Properties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
			
			// 메일 서버 사용자 권한 체크(보안상 필요하다)
			Session pass = Session.getInstance(prop, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("아이디@naver.com", "비밀번호");
				}
			});
			
			// 보내는 메시지 캡슐화
			MimeMessage message = new MimeMessage(pass);
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(subject);
			message.setSentDate(new Date());
			
			// 메시지에 아이디와 암호화되어 있는 비밀번호 담기(데이터베이스에서 가져온 것)
			FindPwdVo vo = new FindPwdVo();
			vo.setId(req.getParameter("id"));
			vo.setEmail(req.getParameter("email"));
			content = dao.findPwd(vo);
			// 복호화
			AES aes = new AES();
			String dec = aes.decrypt(content);
			content = req.getParameter("id")
					+ " 님의 비밀번호는 "
					+ dec
					+ " 입니다.";
			
			message.setContent(content, "text/html;charset=utf-8");
			
			// 메일 전송
			Transport.send(message);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}

}
