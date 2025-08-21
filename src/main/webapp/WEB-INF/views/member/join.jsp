<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="/css/join.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="col-md-4 offset-md-4 mt-5">
		<h1 class="h3 mb-4 text-gray-800">회원가입</h1>
		<form:form method="post" enctype="multipart/form-data"  modelAttribute="memberVO">
			<div class="mb-4">
				<label for="id" class="form-label">ID</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="6자이상 12자 이하">
			</div>
			<div class="mb-4">
				<label for="pw" class="form-label">PW</label>
				<input type="password" class="form-control" id="pw" name="pw" placeholder="최소 8자 이상">
			</div>
			<div class="mb-4">
				<label for="name" class="form-label">이름</label>
				<input type="text" class="form-control" id="name" name="name">
			</div>
			<div class="mb-4">
				<label for="email" class="form-label" >이메일</label>
				<input type="text" class="form-control" id="email" name="email" placeholder="xxxxx@xxxx.com">
			</div>
			<div class="mb-4">
				<label for="phone" class="form-label">휴대폰 번호</label>
				<input type="text" class="form-control" id="phone" name="phone" placeholder="010-xxxx-xxxx">
			</div>
			<div class="info" id="info__birth">
			  <select class="box" id="birth-year" name="birthYear">
			    <option disabled selected>출생 연도</option>
			  </select>
			  <select class="box" id="birth-month" name="birthMonth">
			    <option disabled selected>월</option>
			  </select>
			  <select class="box" id="birth-day" name="birthDay">
			    <option disabled selected>일</option>
			  </select>
			</div>
			<div class="input-group mb-3">
				<input type="file" class="form-control" id="inputGroupFile02" name="profile">
			</div>
			<div class="d-grid mt-5">
				<button class="btn btn-primary" type="submit">회원등록</button>
			</div>
		</form:form>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	<script type="text/javascript" src ="/js/join/join.js"></script>
</body>
</html>