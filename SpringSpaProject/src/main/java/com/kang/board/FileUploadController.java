package com.kang.board;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	
	static String path = "C:\\Users\\K\\eclipse-workspace\\SpringSpaProject\\src\\main\\webapp\\WEB-INF\\upload\\";
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/board/board_insertR")
	public synchronized String insertR(@RequestParam("attFile") List<MultipartFile> mul,
									   @ModelAttribute BoardVo bVo) throws Exception {
		List<AttVo> attList = new ArrayList<>();
		
		boolean flag = service.insertR(bVo);
		if( !flag ) return "저장 오류";
		
		//글 작성 시 파일을 선택하지 않으면 파일업로드 관련부분이 실행되지 않게 한다.
		for(MultipartFile m : mul) {
			if( !m.isEmpty() ) {
				//본문 저장
				attList = fileupload(mul);
				
				service.insertAttList(attList); //throws Exception
			}
		}
		
		return "redirect:/board/board_select";
	}
	
	@RequestMapping("/board/board_updateR")
	public String updateR(@RequestParam("attFile") List<MultipartFile> mul,
						  @ModelAttribute PageVo pVo,
						  @ModelAttribute BoardVo bVo,
						  @RequestParam(value = "delFile", required = false) String[] delFiles) {
		//@RequestParam(value="delFile", required=false, defaultValue="")
		//defFile이 반드시 필요하지 않다는 얘기. 즉 삭제할 파일을 선택하지 않았을 경우.
		//그리고 defaultValue를 작성해서 BoardServie에서 첨부 파일 데이터 삭제 부분 에러까지 해결.
		//아니면 첨부 파일 데이터 삭제부분에서 delFiles != null 조건 추가.
		String msg = "";
		
		try {
			List<AttVo> attList = fileupload(mul); //throws Exception
			bVo.setAttList(attList);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		boolean flag = service.updateR(bVo, delFiles);
		if( !flag ) msg = "수정 오류";
		return msg;
	}
	
	//file upload 공통부분(insertR, updateR, replR)
	public List<AttVo> fileupload(List<MultipartFile> mul) throws Exception {
		List<AttVo> attList = new ArrayList<>();
		
		for(MultipartFile m : mul) {
			if(m.isEmpty()) continue; //삭제할 파일을 선택하지 않은 경우
//			if(m.getOriginalFilename().equals("")) continue;
			UUID uuid = UUID.randomUUID();
			String oriFile = m.getOriginalFilename();
			String sysFile = "";
			
			File temp = new File(path + oriFile);
			m.transferTo(temp); //throws Exception
			sysFile = (uuid.getLeastSignificantBits()*-1) + "-" + oriFile;
			File f = new File(path + sysFile);
			temp.renameTo(f);
			
			AttVo attVo = new AttVo();
			attVo.setOriFile(oriFile);
			attVo.setSysFile(sysFile);
			attList.add(attVo);
		}
		
		return attList;
	}
}
