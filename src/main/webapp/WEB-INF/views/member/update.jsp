<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="col-md-4 offset-md-4 mt-5">
		<h1 class="h3 mb-4 text-gray-800">정보 수정</h1>
		<form:form method="post" enctype="multipart/form-data"  modelAttribute="memberVO">
			<input type="hidden" name="id" value="${member.id }">
			<input type="hidden" name="birthYear" value="${member.birth.year}">
			<input type="hidden" name="birthMonth" value="${member.birth.monthValue}">
			<input type="hidden" name="birthDay" value="${member.birth.dayOfMonth}">
			
			<div class="mb-4">
				<label for="name" class="form-label">이름</label>
				<input type="text" class="form-control" id="name" name="name" value="${member.name }">
			</div>
			<div class="mb-4">
				<label for="email" class="form-label" >이메일</label>
				<input type="text" class="form-control" id="email" name="email" value="${member.email }">
			</div>
			<div class="mb-4">
				<label for="phone" class="form-label">휴대폰 번호</label>
				<input type="text" class="form-control" id="phone" name="phone" value="${member.phone }">
			</div>
			
			<div class="d-grid mt-5">
				<button class="btn btn-primary" type="submit">수정하기</button>
			</div>
		</form:form>
	</div>
	<c:if test="${not empty successMessage}">
		<script>alert("${successMessage}");</script>
	</c:if>
	<c:if test="${not empty errorMessage}">
		<script>alert("${errorMessage}");</script>
	</c:if>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>