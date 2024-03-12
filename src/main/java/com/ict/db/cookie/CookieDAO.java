package com.ict.db.cookie;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class CookieDAO {
	// 실제 사용하는 클래스 : SqlSession
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = CookieDBService.getFactory().openSession();
		}
		return ss;
	}
	
	public static int getJoin(CookieVO cvo) {
		int result = 0;
		result = getSession().insert("CookieUser.c_join", cvo);
		ss.commit();
		return result;
	}
	
	public static CookieVO getLogin(CookieVO cvo) {
		CookieVO cvo2 = null;
		cvo2 = getSession().selectOne("CookieUser.c_login", cvo);
		
		return cvo2;
	}
	
	public static CookieVO getDetail(String id) {
		CookieVO cvo2 = null;
		cvo2 = getSession().selectOne("CookieUser.c_detail", id);
		
		return cvo2;
	}
	
}











