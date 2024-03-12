package com.ict.db.session;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class SessionDAO {
	// 실제 사용하는 클래스 : SqlSession
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = SessionDBService.getFactory().openSession();
		}
		return ss;
	}
	
	public static int getJoin(SessionVO svo) {
		int result = 0;
		result = getSession().insert("SessionUser.s_join", svo);
		ss.commit();
		return result;
	}
	
	public static SessionVO getLogin(SessionVO svo) {
		SessionVO svo2 = null;
		svo2 = getSession().selectOne("SessionUser.s_login", svo);
		
		return svo2;
	}
	
	public static SessionVO getDetail(String id) {
		SessionVO svo2 = null;
		svo2 = getSession().selectOne("SessionUser.s_detail", id);
		
		return svo2;
	}
	
}











