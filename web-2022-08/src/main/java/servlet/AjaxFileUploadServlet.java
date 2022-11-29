package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
	location = "c:/temp",
	maxFileSize = -1, //1024*1024*50 --> 50Mb
	maxRequestSize = -1,
	fileSizeThreshold = 1024*1024*1 //1Mb
)
@WebServlet(urlPatterns = {"/ajaxFileUpload.do"})
//@WebServlet(urlPatterns = {"/jquery/ajaxFileUpload.do"})
public class AjaxFileUploadServlet extends HttpServlet {
	
	String path = "C:\\Users\\K\\eclipse-workspace\\web-2022-08\\src\\main\\webapp\\upload\\";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();

		//일반태그의 값
		String id = req.getParameter("id");
		
		//파일 업로드
		Collection<Part> parts = req.getParts();
		for(Part p : parts) {
			if(p.getHeader("Content-Disposition").contains("filename=")) {
				String sysFile = new Date().getTime() + "-" + p.getSubmittedFileName();
				//String oriFile = p.getSubmittedFileName();
				p.write(path + sysFile);
				p.delete();
				array.add(sysFile);
			}
		}
		
		//결과물을 JSON으로 반환
		obj.put("att", array);
		obj.put("id", id);
		obj.put("msg", "서버가 잘 작동되고 있음");
		out.print(obj.toJSONString());
		/*
		 * out.print(obj.toJSONString())으로 출력하면 이런 형태다
		 * {
		 * 	att : [a.png, b.png, ...]
		 *  id : ...
		 *  msg : ...
		 * }
		 */
	}

}
