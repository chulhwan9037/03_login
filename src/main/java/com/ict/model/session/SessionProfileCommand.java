package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ict.db.session.SessionVO;
import com.ict.model.basic.Command;

public class SessionProfileCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// session에 저장된 svo를 꺼내자
		HttpSession session = request.getSession();
		SessionVO svo =  (SessionVO) session.getAttribute("svo");
		
		request.setAttribute("svo", svo.getPwd());
		return "view/session/profile.jsp";
	}

}
