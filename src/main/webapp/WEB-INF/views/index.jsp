<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="background-image" style="background-image: url('/images/background.jpg'); background-repeat: no-repeat; height: calc(100vh - 56px); background-size: cover;">
		<h1 class="h1" style="width: 1000px; text-align: center; margin: 0 auto; padding-top: 50px;">당신의 후원으로 이 아이를 살릴 수 있습니다</h1>
		<c:if test="${ member ne null }">
			<h1 class="h4" style="width: 1000px; text-align: center; margin: 0 auto; padding-top: 20px;">
				<span id="payment-button" style="cursor: pointer; color: blue; text-decoration: underline;">여기</span>를 눌러서 5000원을 후원해주세요
			</h1>
		</c:if>
		<c:if test="${ member eq null }">
			<h1 class="h4" style="width: 1000px; text-align: center; margin: 0 auto; padding-top: 20px;">
				<a href="/member/login">로그인</a>을 하고 이 강아지를 살려주세요
			</h1>
		</c:if>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	<input type="hidden" class="memberName" value=${ sessionScope.member.name }>
	<input type="hidden" class="memberPhone" value=${ sessionScope.member.phone }>
	<input type="hidden" class="memberEmail" value=${ sessionScope.member.email }>
	<c:if test="${ member ne null }">
		<script src ="/js/pay/donation.js"></script>
	</c:if>
</body>
</html>