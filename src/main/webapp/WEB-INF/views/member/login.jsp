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
		<h1 class="h3 mb-4 text-gray-800">로그인</h1>
		<form:form action="login" method="post" enctype="multipart/form-data"  modelAttribute="memberVO">
			<div class="mb-4">
				<label for="id" class="form-label">ID</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="6자이상 12자 이하">
			</div>
			<div class="mb-4">
				<label for="pw" class="form-label">PW</label>
				<input type="password" class="form-control" id="pw" name="pw" placeholder="최소 8자 이상">
			</div>
			
			
			<div class="d-grid mt-5">
				<button class="btn btn-primary" type="submit">로그인</button>
			</div>
		</form:form>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	
</body>
</html>