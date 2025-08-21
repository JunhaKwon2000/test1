<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>비밀번호 변경</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
    
    
    <div class="col-md-4 offset-md-4 mt-5">
		<h1 class="h3 mb-4 text-gray-800">비밀번호 변경</h1>
		<form action="/member/changePassword" method="post">
			<div class="mb-4">
				<label for="id" class="form-label">현재 비밀번호</label>
				<input type="password" class="form-control"name="currentPassword">
			</div>
			<div class="mb-4">
				<label for="pw" class="form-label">새 비밀번호</label>
				<input type="password" class="form-control"name="newPassword">
			</div>
			<div class="mb-4">
				<label for="name" class="form-label">새 비밀번호 확인</label>
				<input type="password" class="form-control"name="confirmPassword">
			</div>
			<div class="d-grid mt-5">
				<button class="btn btn-primary" type="submit">변경하기</button>
			</div>
		</form>	
    </div>
    
    <!-- 에러/성공 메시지 -->

    <c:if test="${not empty errorMessage}">
	  <script>
	    alert("${errorMessage}");
	  </script>
	</c:if>
</body>
</html>
