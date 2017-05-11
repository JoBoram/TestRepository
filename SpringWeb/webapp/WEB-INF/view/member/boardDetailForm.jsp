<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function insertReply() {
		var reply = document.getElementById("reply");
		reply.action = "/board/insertReply.do";
		reply.submit();
	}
</script>
<title>내용 상세보기화면</title>
</head>
<body>

	<table style="width: 900px; text-align: center;" border="1"
		cellspacing="0px">
		<tr>
			<th>No.</th>
			<th>ID</th>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
		</tr>
		<tr>
			<td>${boardBean.no}</td>
			<td>${boardBean.memberId}</td>
			<td>${boardBean.boardTitle}</td>
			<td>${boardBean.boardContent}</td>
			<td>${boardBean.boardRegDate}</td>
		</tr>
	</table>



	<br />
	<br />
	<!-- 댓글 부분 -->
	<form id="reply" method="post">
		<input type="hidden" name="boardNo" value="${ boardBean.no }" />
		<input type="hidden" name="memberName"
			value="${ sessionScope.memberLoginBean.memberId }" /> ${ sessionScope.memberLoginBean.memberId }
		&nbsp;&nbsp; <input type="text" name="replyContent" />
		<button type="button" onclick="insertReply();">쓰기</button>
	</form>
	<br />
	<table>
		<c:forEach var="replyBean" items="${ replyList }">
			<tr>
				<th>${ sessionScope.memberLoginBean.memberId  }</th>
				<td width="200">${replyBean.replyContent}</td>
				<td>${replyBean.replyRegDate}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>