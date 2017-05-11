<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


   <table>
      <tr>
         <th>번호</th>
         <th>ID</th>
         <th>이름</th>
         <th>나이</th>
         <th>지역</th>
         <th>휴대폰</th>
         <th>성별</th>
         <th>삭제</th>
      </tr>


      <c:forEach var="bean" items="${memberList}" varStatus="status">
         <tr>

            <td>${bean.no}</td>
            <td>${bean.memberId}</td>
            <td>${bean.memberName}</td>
            <td>${bean.memberAge}</td>
            <td>${bean.memberArea}</td>
            <td>${bean.memberHp}</td>
            <td>${bean.memberSex}</td>
            <td><button type="button" onclick="" >삭제</button></td>

         </tr>

      </c:forEach>
      <tr>

         <td colspan="7">검색<input type="text" name="searchText" />
            <button type="button" onclick="alert('메롱');">검색</button>
      </tr>
   </table>

</body>
</html>