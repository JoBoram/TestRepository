package com.test.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.test.web.member.bean.MemberBean;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		MemberBean mBean = (MemberBean) request.getSession().getAttribute(Constants.MEMBER_LOGIN_BEAN);
		if (mBean != null) {
			return true;
		}
		
		response.sendRedirect("/member/loginFormAjax.do");
		return false;
	}
	/**
	 * 그리워하면 언젠간 만나게되느느으으으으으으응!!!!
	 * 어느 여헝와와 같은 일들이 이뤄져 가기르으으을 
 * 힘겨워한날에 ~~~나나나나나나나나~~~아름다운 기어속의 연ㄹ그대영~~~~~~~
	 * */

}


