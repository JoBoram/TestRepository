package com.test.web.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.common.Constants;
import com.test.web.common.bean.PagingBean;
import com.test.web.member.bean.MemberBean;
import com.test.web.member.service.MemberService;

@Controller
public class MemberAjaxController {

	@Autowired
	private MemberService memberService;

	/** 로그인 화면 */
	@RequestMapping("/member/loginFormAjax")
	public String loginFormAjax() {
		return "/member/loginFormAjax";
	}

	/** 로그인 처리 */
	@RequestMapping("/member/loginProcAjax")
	@ResponseBody
	public Map<String, Object> loginProcAjax(MemberBean bean, HttpServletRequest req) {
		Map<String, Object> resMap = new HashMap<String, Object>();

		// 로그인 실패
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put("mBean", bean);

		try {
			MemberBean memberBean = memberService.selectMember(bean);

			if (memberBean != null && memberBean.getMemberId().equals(bean.getMemberId())) {
				// 로그인 성공 - 세션에 저장
				req.getSession().setAttribute(Constants.MEMBER_LOGIN_BEAN, memberBean);
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				return resMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}

	/** 회원가입 화면 */
	@RequestMapping("/member/insertMemberFormAjax")
	public String insertMemberFormAjax() {
		return "/member/insertMemberFormAjax";
	}

	/** 회원가입 처리를 한다. */
	@RequestMapping("/member/insertMemberProcAjax")
	@ResponseBody
	public Map<String, Object> insertMemberProc(MemberBean memberBean) {
		Map<String, Object> resMap = new HashMap<String, Object>();

		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "회원가입에 실패하였습니다");

		// DB insert
		try {
			int res = memberService.insertMember(memberBean);

			if (res > 0) {
				resMap.put(Constants.RESULT, Constants.RESULT_OK);
				resMap.put(Constants.RESULT_MSG, "회원가입에 성공하였습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
	
	/** 회원정보 리스트 화면*/
	@RequestMapping("/member/selectMemberListForm")
	public String selectMemberList() {
		return "/member/selectMemberList";
	}

	/** 회원정보 리스트 표시 */
	@RequestMapping("/member/selectMemberListAjax")
	@ResponseBody
	public Map<String, Object> selectMemberList(MemberBean memberBean, PagingBean pagingBean, Model model) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put(Constants.RESULT, Constants.RESULT_FAIL);
		resMap.put(Constants.RESULT_MSG, "회원 리스트 조회에 실패하였습니다");

		try {
			// DB로부터 데이터를 가져온다.
			List<MemberBean> list = memberService.selectMemberList(memberBean);
			
			// JSP로 보내기 위해서 데이터를 적재한다.
			resMap.put("memberList", list);

			resMap.put(Constants.RESULT, Constants.RESULT_OK);
			resMap.put(Constants.RESULT_MSG, "회원 리스트 조회에 성공하였습니다");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resMap;
	}
}
