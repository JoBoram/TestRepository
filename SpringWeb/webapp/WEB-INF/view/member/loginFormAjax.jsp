<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
	<script type="text/javascript" src="/js/common/jquery/jquery-3.2.1.js"></script>
	<!-- body 부분이 다 실행 된 후 script 호출 -->
	<script type="text/javascript">
		$(document).ready(function(){
		//selector : $("#btnLogin") = getattribute 와 같다.
		//var btnLogin = $("#btnLogin");
		//btnLogin.click(function{});
			$("#btnLogin").click(function() {
				$.ajax({
					type:"post",
					url:"/member/loginProcAjax.do",
					data:{
						memberId:$("#memberId").val(),
						memberPw:$("#memberPw").val()
					},
					dataType:"json",
					success:function(data){
						console.log(data);
						
						if(data.result == "ok"){
							location.replace("/member/boardFirstForm.do");
							return;
						}else{
							alert("로그인을 실패하였습니다");
							$("#memberPw").focus();
						}
					},
					error:function(xhr, status, error){
						console.log(xhr);
						alert("error\nxhr: "+xhr+",status: "+status+",error: "+error);
					}
				});
			});
		});

		$(function() {

		});
	</script>
</head>
<body>

		ID <input type="text" id="memberId"  /><br /> 
		PW <input type="password" id="memberPw"   /><br /> 
		<button id="btnLogin" type="button" >로그인</button>
	
		<a href="/member/insertMemberFormAjax.do">회원가입</a>
	
</body>
</html>