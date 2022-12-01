package servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import member.MemberVo;
import member.MybatisMemberDao;
import member.MybatisPageVo;

@MultipartConfig(
	location          = "c:/temp",
	maxFileSize       = -1,
	maxRequestSize    = -1,
	fileSizeThreshold = 4096
)
@WebServlet(urlPatterns = {"/mmfs.do"})
public class MybatisMemberFileUploadServlet extends HttpServlet {
	
	public static String path = "C:\\Users\\K\\eclipse-workspace\\web-2022-08\\src\\main\\webapp\\upload\\";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getParameter("job")) {
		case "insert":
			insert(req, resp);
			break;
		}
	}
	
	public void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection<Part> parts = req.getParts();
		MemberVo vo = new MemberVo();
		MybatisPageVo pVo = new MybatisPageVo();
		pVo.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		pVo.setFindStr(req.getParameter("findStr"));
		
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
				case "mDate":
					vo.setmDate(value);
					break;
				}
			}
		}
		
		MybatisMemberDao dao = new MybatisMemberDao();
		String msg = dao.insert(vo);
		List<MemberVo> list = dao.select(pVo);
		
		req.setAttribute("msg", msg);
		req.setAttribute("pVo", pVo);
		req.setAttribute("list", list);
		RequestDispatcher rd = req.getRequestDispatcher("mybatis/member_select.jsp");
		rd.include(req, resp);
	}
	
}
