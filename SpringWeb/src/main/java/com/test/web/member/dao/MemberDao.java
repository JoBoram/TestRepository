package com.test.web.member.dao;

import com.test.web.member.bean.MemberBean;

public interface MemberDao {

	/** 회원정보를 조회해서 가져온다. **/
	public MemberBean selectMember(MemberBean bean);

	/** 회원정보를 삽입한다. */
	public int insertMember(MemberBean bean);

	/** 회원정보를 수정한다. */
	public int updateMember(MemberBean bean);
}
