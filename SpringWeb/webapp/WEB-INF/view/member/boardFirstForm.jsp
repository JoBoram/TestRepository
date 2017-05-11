
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 성공 화면</title>
</head>
<body>
	<h1>환영합니다.</h1>
	<br />
	<h3>${sessionScope.memberLoginBean.memberName}님</h3>
	<br />
	<a
		href="/member/selectMember.do?memberId=${sessionScope.memberLoginBean.memberId}">
		회원정보보기 </a>&nbsp;&nbsp;&nbsp;
	<a
		href="/member/updateMemberForm.do?memberId=${sessionScope.memberLoginBean.memberId}">
		회원정보수정 </a>&nbsp;&nbsp;&nbsp;
	<a href="/member/boardListForm.do"> 게시판이동 </a>
</body>
</html>