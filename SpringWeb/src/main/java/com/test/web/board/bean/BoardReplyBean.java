package com.test.web.board.bean;

public class BoardReplyBean {
	private String no;
	private String boardNo;
	private String replyContent;
	private String replyRegDate;
	
	public String getReplyNo() {
		return no;
	}
	public void setReplyNo(String no) {
		this.no = no;
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyRegDate() {
		return replyRegDate;
	}
	public void setReplyRegDate(String replyRegDate) {
		this.replyRegDate = replyRegDate;
	}
	
	
}
