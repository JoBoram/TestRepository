<%@page import="com.test.web.member.bean.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기 화면</title>
<script type="text/javascript">
	function insertBoard() {
		var boardForm = document.getElementById("boardForm");

		boardForm.action = "/board/writeBoardProc.do";
		boardForm.method = "post";

		boardForm.submit();
	}
</script>
</head>
<body>

	<div id="wrap" align="center">
		<h1>게시글 등록</h1>
		<form id="boardForm" >
			<input type="hidden" name="memberId" value="${sessionScope.memberLoginBean.memberId}">
			
			<table>
				<tr>
					<th>ID</th>
					<td>${sessionScope.memberLoginBean.memberId}</td>
					
				</tr>

				<tr>
					<th>작성자</th>
					<td>${sessionScope.memberLoginBean.memberName}</td>
				</tr>

				<tr>
					<th>제목</th>
					<td><input type="text" name="boardTitle"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="15" cols="70" name="boardContent"></textarea></td>
				</tr>
			</table>
			<br> <br>
			<button type="button" onclick="insertBoard();">완료</button>
			<button type="button" onclick="javascript:history.back();">취소</button>
		</form>

	</div>

</body>
</html>