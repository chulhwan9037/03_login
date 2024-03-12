package com.ict.model.file;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUP {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 실제 저장위치를 얻어내자
			String path = request.getServletContext().getRealPath("upload");
			
			// 파일 업로드를 하면 request 대신 사용하는 클래스
			MultipartRequest mr = new MultipartRequest(request, 
					path,
					100*1024*1024,   // 100MB, 업로드 용량 제한
					"utf-8",		 // 한글처리
					// 업로드 위치에 같은 이름의 파일이 있으면 파일이름 뒤에 숫자가 붙는다.
					new DefaultFileRenamePolicy()  
					);
			
			return "view/fileup_down/FileUp_result.jsp";
		}catch(Exception e){
			
		}
		return null;
	}
}
