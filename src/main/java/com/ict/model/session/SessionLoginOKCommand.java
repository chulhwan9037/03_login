package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ict.db.session.SessionDAO;
import com.ict.db.session.SessionVO;
import com.ict.model.basic.Command;

public class SessionLoginOKCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
			
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		SessionVO svo = new SessionVO();
		svo.setId(id);
		svo.setPwd(pwd);
		
		SessionVO svo2 = SessionDAO.getLogin(svo);
		
		if(svo2 == null) {
			return "view/session/loginForm.jsp";
		}else {
			// session을 만들어서 session 저장한다.
			// session.setAttribute("이름", 값);
			// session.getAttribute("이름");
			// session.removeAttribute("이름");
			
			// 기타 주요메서드
			// - getID : 세션 고유ID 반환
			// - getCreationTime() : 세션이 생성된 시간 반환
			// - getLastAccessedTime() : 마지막에 접근한 시간 반환
			// - inValidate() : 세션 전체 초기화(삭제)
			// - setMasInactiveInterval(시간) : 세션 시간 제한 
			
			// -- 생명주기 : 제한 시간을 정하지 않으면 브라우저가 종료되면 세션 데이터도 사라진다.
			
			HttpSession session = request.getSession();
			session.setAttribute("svo", svo2);
			
			return "view/session/index.jsp";
		}
	
	}

}
