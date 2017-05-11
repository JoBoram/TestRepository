package com.test.web.board.bean;

public class BoardBean {

	private String no;
	private String memberId;
	private String boardTitle;
	private String boardContent;
	private String boardRegDate;

	//getter/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getMemberId() {
		return memberId;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public String getBoardRegDate() {
		return boardRegDate;
	}

	//setter/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
	}

}
