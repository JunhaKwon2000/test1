<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<div class="col-md-4 offset-md-4 mt-5">
		<h1 class="h3 mb-4 text-gray-800">내 정보</h1>
		
		<div class="bg-light rounded" 
			     style="background-image: url('/files/profile/${memberVO.profileVO.saveName }');
			            background-size: cover;
			            background-position: center;
			            width: 50%;
			            height: 500px;">
			</div>
		
		
			<div class="mb-4">
				<br>
				<label for="id" class="form-label">ID : ${member.id }</label>
			</div>
			<div class="mb-4">
				<label for="name" class="form-label">이름 : ${member.name}</label>
			</div>
			<div class="mb-4">
				<label for="email" class="form-label" >이메일 : ${member.email}</label>
			</div>
			<div class="mb-4">
				<label for="phone" class="form-label">전화번호 : ${member.phone}</label>
			</div>
			<div class="mb-4">
			  	<label>생년월일 : ${member.birth}</label>
			</div>
			
		
			<div class="d-grid mt-5">
				<a class="btn btn-primary" href="/member/update">내 정보 수정하기</a>
			</div>
			<div class="d-grid mt-5">
				<a class="btn btn-primary" href="/member/passwordChange">비밀번호 변경하기</a>
			</div>
			
			<form action="/member/delete" method="post" id="frm"></form>
			
				<div class="d-grid mt-5">
					<button class ="btn btn-danger delete">회원탈퇴</button>
				</div>
	</div>

<script type="text/javascript" src ="/js/join/delete.js"></script>
</body>
</html>