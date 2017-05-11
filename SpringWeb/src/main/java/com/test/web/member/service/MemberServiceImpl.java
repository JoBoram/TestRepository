package com.test.web.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.member.bean.MemberBean;
import com.test.web.member.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public MemberBean selectMember(MemberBean bean) throws Exception {
		return memberDao.selectMember(bean);
	}

	@Override
	public List<MemberBean> selectMemberList(MemberBean bean) throws Exception {
		return memberDao.selectMemberList(bean);
	}

	@Override
	public int insertMember(MemberBean bean) throws Exception {
//		int res = memberDao.insertMember(bean);
//		System.out.println(res);
		return memberDao.insertMember(bean);
	}

	@Override
	public int updateMember(MemberBean bean) throws Exception {
		return memberDao.updateMember(bean);
	}

}
