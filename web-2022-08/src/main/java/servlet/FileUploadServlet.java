package servlet;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
	location          = "c:/temp", // 임시 폴더
	maxFileSize       = -1,        // 업로드할 파일 최대 크기. -1이면 무제한
	maxRequestSize    = -1,        // 파일을 업로드하기 위해 필요한 request 크기. -1이면 무제한
	fileSizeThreshold = 4096       // 파일의 크기가 지정된 값 보다 크면 임시 폴더에 저장한 후 계속 업로드를 진행한다. 크기가 작으면 메모리에 일시저장
)
@WebServlet(urlPatterns = {"/upload.do"})
public class FileUploadServlet extends HttpServlet {
	// 이클립스에서 upload폴더 우클릭 > 프로퍼티에서 경로 복사 > 이스케이프해주고 마지막에 \\추가
	String path = "C:\\Users\\K\\eclipse-workspace\\web-2022-08\\src\\main\\webapp\\upload\\";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer info = new StringBuffer();
		info.append("<li>content type: " + req.getContentType());
		
		Collection<Part> parts = req.getParts();
		for(Part p : parts) {
			info.append("<li>tag name: " + p.getName());      // 그냥 한번 찍어 보자
			info.append("<li>part content type: " + p.getContentType());
			
			if(p.getHeader("Content-Disposition").contains("filename=")) {
				info.append("<li>file size: " + p.getSize());
				info.append("<li>file name: " + p.getSubmittedFileName());
				info.append("<hr/>");
				
				if(p.getSize() > 0) {
					p.write(path + p.getSubmittedFileName()); // path는 upload 폴더의 절대경로를 적는다(저장하기 위해) 단, 접근할 때는 웹의 상대경로로 접근한다.
					p.delete();
				}
			} else {
				String msg = req.getParameter("msg");
				req.setAttribute("msg", msg);
			}
		}
		
		req.setAttribute("info", info.toString());
		RequestDispatcher rd = req.getRequestDispatcher("jsp/file_upload_result.jsp");
		rd.forward(req, resp);
	}

}
