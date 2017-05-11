<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 리스트 화면</title>
</head>
<body>
	<button type="button"
		onclick="location.href='/member/boardWriteForm.do'">글쓰기</button>
	<table style="width: 900px; text-align: center;" border="1"
		cellspacing="0px">
		<tr>
			<th>No.</th>
			<th>ID</th>
			<th>타이틀</th>
			<th>내용</th>
			<th>날짜</th>
			<th>내용보기</th>
		</tr>

		<c:forEach var="bean" items="${boardList}" varStatus="status">
			<tr>
				<td>${bean.no}</td>
				<td>${bean.memberId}</td>
				<td>${bean.boardTitle}</td>
				<td>${bean.boardContent}</td>
				<td>${bean.boardRegDate}</td>

				<td><button type="button"
						onclick="location.href='/member/boardDetailForm.do?no=${bean.no}'">보기</button></td>
			</tr>

		</c:forEach>

		<tr>
			<td colspan="7">
				<!--  
				 &lt;&lt;처음&nbsp;&nbsp;&nbsp;
				 &lt;이전 [1] [2] [3] [4] 다음&gt; 
				 &nbsp;&nbsp;&nbsp;마지막&gt;&gt;
				 --> <c:if test="${pBean.groupNo > 1}">
					<a href="/member/boardListForm.do?pageNo=${pBean.pageStartNo - 1}&searchType=${param.searchType}
							&searchText=${param.searchText}">&lt;이전</a>
				</c:if> <c:forEach var="i" begin="${pBean.pageStartNo}"
					end="${pBean.pageEndNo}">
					<c:choose>
						<c:when test="${pBean.pageNo != i}">
							<a href="/member/boardListForm.do?pageNo=${i}&searchType=${param.searchType}
							&searchText=${param.searchText}">[${i}]</a>
						</c:when>
						<c:otherwise>
				 			[${i}]
				 		</c:otherwise>
					</c:choose>

				</c:forEach> <c:if test="${pBean.groupNo < pBean.totalGroupCount}">
					<a href="/member/boardListForm.do?pageNo=${pBean.pageEndNo + 1}&searchType=${param.searchType}
							&searchText=${param.searchText}">다음&gt;</a>
				</c:if>

			</td>
		</tr>
		<tr>

			<td colspan="7">
				<form action="/member/boardListForm.do" method="get">
					검색: <select name="searchType">
						<option value="id">ID</option>
						<option value="title">제목</option>
					</select> <input type="text" name="searchText" /> <input type="submit"
						value="검색" />
				</form>
			</td>
		</tr>

	</table>
</body>
</html>