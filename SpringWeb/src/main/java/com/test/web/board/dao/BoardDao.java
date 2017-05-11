package com.test.web.board.dao;

import java.util.List;

import com.test.web.board.bean.BoardBean;
import com.test.web.board.bean.BoardReplyBean;
import com.test.web.common.bean.PagingBean;

public interface BoardDao {

	/** 회원정보를 조회해서 리스트로 가져온다. **/
	public List<BoardBean> selectBoardList(PagingBean bean);

	public BoardBean selectBoard(BoardBean bean);

	/** 삽입한다. */
	public int insertBoard(BoardBean bean);

	public int updateBoard(BoardBean bean);

	/** 전체 레코드 갯수 조회 **/
	public int selectBoardListTotalCount(PagingBean bean);

	/** 게시글에 따른 댓글 조회 */
	public List<BoardReplyBean> selectReplyList(BoardBean boardBean);

	/** 댓글 추가 */
	public int insertReply(BoardReplyBean replyBean);

	/** 댓글 삭제 */
	public int deleteReply(BoardBean boardBean);
}
