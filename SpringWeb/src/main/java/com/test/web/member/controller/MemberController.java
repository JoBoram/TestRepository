package com.test.web.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.common.Constants;
import com.test.web.common.bean.PagingBean;
import com.test.web.member.bean.MemberBean;
import com.test.web.member.dao.MemberDao;

@Controller
// @RequestMapping("/member")
public class MemberController {

	@Value("#{config['admin.id']}")
	private String ADMIN_ID;

	@Value("#{config['admin.pw']}")
	private String ADMIN_PW;

	@Autowired
	private MemberDao memberDao;

	/** 로그인 화면 */
	@RequestMapping("/member/loginForm")
	public String loginForm() {
		return "/member/loginForm";
	}

	/** 로그인 처리 */
	@RequestMapping("/member/loginProc")
	public String loginProc(MemberBean bean, Model model, HttpServletRequest req) {
		MemberBean memberBean = memberDao.selectMember(bean);
		if (memberBean != null && memberBean.getMemberId().equals(bean.getMemberId())) {
			// 로그인 성공
			// 세션 : 브라우저 -> request 하면 자동으로 생긴다. 서버가 가지고 있는 정보, request 객체가 가지고
			// 있다. 정보를 계속 저장할 수 있다.
			// 쿠키 : Client 가 가지고 있는 정보
			// forwarding : 서버 내부 이동 model을 심는다
			// redirect : 클라이언트 강제 이동 model이 필요없다, reset
			req.getSession().setAttribute(Constants.MEMBER_LOGIN_BEAN, memberBean);
			model.addAttribute("result", "success");
			model.addAttribute("memberBean", memberBean);
			return "/member/boardFirstForm";
		} else {
			model.addAttribute("result", "fail");
			return "/member/loginForm";
		}

	}

	////////////////////////////////////////////////////////////////////////////////////
	/** DB **/
	@RequestMapping("/member/selectMember")
	public String selectMember(MemberBean memberBean, Model model) {
		// DB로부터 데이터를 가져온다.
		MemberBean mBean = memberDao.selectMember(memberBean);
		// JSP로 보내기 위해서 데이터를 적재한다.
		model.addAttribute("memberBean", mBean);

		return "/member/member";
	}

	@RequestMapping("/member/insertMemberForm")
	/** 회원가입 화면 */
	public String insertMemberForm() {
		return "/member/insertMemberForm";
	}

	/** 회원가입 처리를 한다. */
	@RequestMapping("/member/insertMemberProc")
	public String insertMemberProc(MemberBean memberBean) {
		// DB insert
		int res = memberDao.insertMember(memberBean);
		System.out.println(res);
		return "redirect:/member/loginForm.do";
	}

	@RequestMapping("/member/updateMemberForm")
	/** 회원가입 수정 화면 */
	public String updateMemberForm(MemberBean memberBean, Model model) {
		MemberBean resBean = memberDao.selectMember(memberBean);
		model.addAttribute("memberBean", resBean);
		return "/member/updateMemberForm";
	}

	/** 회원정보 수정 처리를 한다. */
	@RequestMapping("/member/updateMemberProc")
	public String updateMemberProc(MemberBean memberBean, Model model) {

		model.addAttribute(Constants.RESULT, Constants.RESULT_FAIL);
		model.addAttribute("memberBean", memberBean);

		// DB insert
		int res = memberDao.updateMember(memberBean);
		System.out.println(res);

		System.out.println(ADMIN_ID);
		System.out.println(ADMIN_PW);

		if (res > 0) {
			model.addAttribute(Constants.RESULT, Constants.RESULT_OK);

		}

		return "member/updateMemberForm";
	}

	/** 회원정보 리스트 표시 */
	@RequestMapping("/member/selectMemberList")
	public String selectMemberList(MemberBean memberBean, PagingBean pagingBean, Model model) {
		// DB로부터 데이터를 가져온다.
		List<MemberBean> list = memberDao.selectMemberList(memberBean);
		// JSP로 보내기 위해서 데이터를 적재한다.
		model.addAttribute("memberList", list);

		return "/member/memberList";
	}

}
