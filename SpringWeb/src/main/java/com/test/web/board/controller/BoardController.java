package com.test.web.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.board.bean.BoardBean;
import com.test.web.board.bean.BoardReplyBean;
import com.test.web.board.dao.BoardDao;
import com.test.web.common.Constants;
import com.test.web.common.bean.PagingBean;
import com.test.web.member.bean.MemberBean;
import com.test.web.member.dao.MemberDao;

@Controller
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	private MemberDao memberDao;

	////////////////////////////////////////////////////////////////////////////////////

	/** 게시판 처음화면 */
	@RequestMapping("/member/boardFirstForm")
	public String boardFirstForm() {
		return "/member/boardFirstForm";
	}

	/** 게시판 리스트화면 */
	@RequestMapping("/member/boardListForm")
	public String boardListForm(PagingBean pBean, Model model) {
		// 전체 레코드 갯수 취득
		int totRecord = boardDao.selectBoardListTotalCount(pBean);

		// 페이징 계산
		pBean.calcPage(totRecord);

		// DB로부터 데이터를 가져온다.
		List<BoardBean> list = boardDao.selectBoardList(pBean);
		// JSP로 보내기 위해서 데이터를 적재한다.
		model.addAttribute("boardList", list);
		model.addAttribute("pBean", pBean);
		return "/member/boardListForm";
	}

	/** 게시판 글쓰기화면 */
	@RequestMapping("/member/boardWriteForm")
	public String boardWriteForm(HttpServletRequest request, Model model) {
		MemberBean bean = (MemberBean) request.getSession().getAttribute(Constants.MEMBER_LOGIN_BEAN);
		model.addAttribute("memberBean", bean);

		return "/member/boardWriteForm";
	}

	/** 게시판 상세화면 */
	@RequestMapping("/member/boardDetailForm")
	public String boardDetailForm(BoardBean boardBean, BoardReplyBean replyBean, Model model) {
		BoardBean bBean = boardDao.selectBoard(boardBean);
		model.addAttribute("boardBean", bBean);

		// replyList 가져오기
		List<BoardReplyBean> list = boardDao.selectReplyList(boardBean);
		model.addAttribute("replyList", list);
		
		return "/member/boardDetailForm";
	}

	@RequestMapping("/board/writeForm")
	public String writeForm(MemberBean memberBean, BoardBean boardBean, Model model) {

		MemberBean mBean = memberDao.selectMember(memberBean);

		model.addAttribute("memberBean", mBean);

		return "/board/writeForm";

	}

	@RequestMapping("/board/writeBoardProc")
	public String writeProc(BoardBean boardBean) {
		int res = boardDao.insertBoard(boardBean);

		System.out.println(res);

		return "redirect:/member/boardListForm.do";

	}

	////////////////////// 댓글 ///////////////////////
	/** 새 댓글 추가하기 - DB에 댓글 추가 + 갱신 (redirect) */
	@RequestMapping("/board/insertReply")
	public String insertReply(BoardReplyBean replyBean) {
		// 댓글 DB에 추가
		int res = boardDao.insertReply(replyBean);
		// 다시 현재 게시글로 리다이렉트
		return "redirect:/member/boardDetailForm.do?no=" + replyBean.getBoardNo();
	}
}
