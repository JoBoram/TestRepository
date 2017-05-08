package com.test.web.member.bean;

//DTO
public class MemberBean {

	private String no;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberAge;
	private String memberArea;
	private String memberHp;
	private String memberSex;
	private String hp1;
	private String hp2;
	private String hp3;

	public String getHp1() {
		return hp1;
	}

	public String getHp2() {
		return hp2;
	}

	public String getHp3() {
		return hp3;
	}

	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}

	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}

	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}

	public String getNo() {
		return no;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getMemberAge() {
		return memberAge;
	}

	public String getMemberArea() {
		return memberArea;
	}

	public String getMemberHp() {
		return memberHp;
	}

	public String getMemberSex() {
		return memberSex;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}

	public void setMemberArea(String memberArea) {
		this.memberArea = memberArea;
	}

	public void setMemberHp(String memberHp) {
		this.memberHp = memberHp;
		if (memberHp != null) {
			try {
				String[] strArr = memberHp.split("-");
				for (int i = 0; i < strArr.length; i++) {
					if (i == 0)
						hp1 = strArr[i];
					if (i == 1)
						hp2 = strArr[i];
					if (i == 2)
						hp3 = strArr[i];
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

}
