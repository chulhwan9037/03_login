package com.ict.model.session;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartAdd {
	// sessio 카트에 담기
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String fruits = request.getParameter("fruits");
		HttpSession session = request.getSession();
		
		// 장바구니의 크기를 알 수 없다. (컬렉션에 담아야 한다.)
		
		// 세션에 있는 list 호출
		ArrayList<String> list = 
				(ArrayList<String>) session.getAttribute("list");
		// 맨 처음 해당 페이지에 오면 session에는 list가 없다.
		if(list == null) {
			list = new ArrayList<String>();
			session.setAttribute("list", list);
		}
		// 리스트에 정보를 추가
		list.add(fruits);
		
		return "view/session_cart/session_cart.jsp";
	}
}
