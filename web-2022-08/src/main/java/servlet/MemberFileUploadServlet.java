package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import member.MemberDao;
import member.MemberVo;

@MultipartConfig(
	location          = "c:/temp", // 임시 폴더
	maxFileSize       = -1,        // 업로드할 파일 최대 크기. -1이면 무제한
	maxRequestSize    = -1,        // 파일을 업로드하기 위해 필요한 request 크기. -1이면 무제한
	fileSizeThreshold = 4096       // 파일의 크기가 지정된 값 보다 크면 임시 폴더에 저장한 후 계속 업로드를 진행한다. 크기가 작으면 메모리에 일시저장
)
@WebServlet(urlPatterns = {"/memberUpload.do"})
public class MemberFileUploadServlet extends HttpServlet {
	// 이클립스에서 upload폴더 우클릭 > 프로퍼티에서 경로 복사 > 이스케이프해주고 마지막에 \\추가
	// MemberDao.java update()에서 사용하기 위해 public static으로 선언했는데 현업에서는 이렇게 안쓴다
	public static String path = "C:\\Users\\K\\eclipse-workspace\\web-2022-08\\src\\main\\webapp\\upload\\";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String job = req.getParameter("job");
		
		switch(job) { // 조건 분기
		case "create":
			create(req, resp);
			break;
		case "update":
			update(req, resp);
			break;    // job이 update일 경우 밑으로 흐르지 않고 메서드 종료
		}
	}
	
	public void create(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Collection<Part> parts = req.getParts();
		MemberVo vo = new MemberVo();
		
		for(Part p : parts) { // id, name, gender, phone, file
			if(p.getHeader("Content-Disposition").contains("filename=")) { // file일 경우
				if(p.getSize() > 0) {
					// p.getSubmittedFileName()은 오리지날 파일명이라서 사용자에 따라 중복 가능성이 있다. 그래서 날짜 등의 시리얼넘버를 추가해서 중복으로 생기는 문제를 방지한다.
					String sysFile = new Date().getTime() + "-" + p.getSubmittedFileName();
					String oriFile = p.getSubmittedFileName();
					vo.setSysFile(sysFile);
					vo.setOriFile(oriFile);
					
					// path는 upload 폴더의 절대경로를 적는다(저장하기 위해) 단, 접근할 때는 웹의 상대경로로 접근한다.
					p.write(path + sysFile);
					p.delete();
				}
			} else { // file이 아닌 경우
				/* 
				결국 p가 id라면 name,gender,phone null. p가 name이라면 id,gender,phone null이라 결국 마지막에 있는 phone빼고 다 null이 된다.
				req.setAttribute("id", req.getParameter("id"));
				req.setAttribute("name", req.getParameter("name"));
				req.setAttribute("gender", req.getParameter("gender"));
				req.setAttribute("phone", req.getParameter("phone"));
				 */
				
				// 그래서 이런식으로 받아서 vo에 set하고 dao에 준다
				String tag = p.getName();
				String value = req.getParameter(tag);
				//req.setAttribute(tag, value);
				switch(tag) {
				case "id":
					vo.setId(value);
					break;
				case "name":
					vo.setName(value);
					break;
				case "gender":
					vo.setGender(value);
					break;
				case "phone":
					vo.setPhone(value);
					break;
				}
			}
		}
		
		MemberDao dao = new MemberDao();
		String msg = dao.insert(vo);
		
		req.setAttribute("msg", msg);
		RequestDispatcher rd = req.getRequestDispatcher("member/member_insert_result.jsp");
		rd.forward(req, resp);
		//PrintWriter out = resp.getWriter();
		//out.print(msg);
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Collection<Part> parts = req.getParts();
		MemberVo vo = new MemberVo();
		
		for(Part p : parts) {
			if(p.getHeader("Content-Disposition").contains("filename=")) { // file일 경우
				if(p.getSize() > 0) {
					String sysFile = new Date().getTime() + "-" + p.getSubmittedFileName();
					String oriFile = p.getSubmittedFileName();
					vo.setSysFile(sysFile);
					vo.setOriFile(oriFile);
					
					p.write(path + sysFile);
					p.delete();
				}
			} else {
				String tag = p.getName();
				String value = req.getParameter(tag);
				
				switch(tag) {
				case "id":
					vo.setId(value);
					break;
				case "name":
					vo.setName(value);
					break;
				case "gender":
					vo.setGender(value);
					break;
				case "phone":
					vo.setPhone(value);
					break;
				case "delFile":
					vo.setDelFile(value);
					break;
				}
			}
		}
		
		MemberDao dao = new MemberDao();
		String msg = dao.update(vo);
		
		PrintWriter out = resp.getWriter();
		out.print(msg);
	}

}









