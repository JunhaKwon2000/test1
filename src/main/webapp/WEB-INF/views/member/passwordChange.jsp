<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>비밀번호 변경</title>
</head>
<body>
    <h2>비밀번호 변경</h2>
    
    <form action="/member/changePassword" method="post">
        <div>
            <label>현재 비밀번호</label>
            <input type="password" name="currentPassword" required>
        </div>
        <div>
            <label>새 비밀번호</label>
            <input type="password" name="newPassword" required>
        </div>
        <div>
            <label>새 비밀번호 확인</label>
            <input type="password" name="confirmPassword" required>
        </div>
        <button type="submit">변경하기</button>
    </form>

    <!-- 에러/성공 메시지 -->
    <c:if test="${not empty errorMessage}">
        <p style="color:red">${errorMessage}</p>
    </c:if>
    <c:if test="${not empty successMessage}">
        <p style="color:green">${successMessage}</p>
    </c:if>
</body>
</html>
