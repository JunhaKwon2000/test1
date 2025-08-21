<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="col-md-8 offset-md-2 mt-5">
		<div class="d-flex flex-wrap justify-content-start align-self-center">
		 	<div class="bg-light rounded" 
			     style="background-image: url('/files/product/${ product.productFileVO.saveName }');
			            background-size: cover;
			            background-position: center;
			            width: 50%;
			            height: 500px;">
			</div>
		    <div>
			    <h5>${ product.productName }</h5>
			    <p>${ product.productContent }</p>
			    <p>상품 종류: ${ product.productKindVO.kindName }</p>
			    <p>${ product.productPrice }원</p>
			    <c:if test="${ member eq null }">
			    	<p><a href="/member/login">로그인</a>후 결제하실 수 있습니다</p>
			    </c:if>
			    <c:if test="${ member ne null }">
				    <button class="button btn btn-primary" id="payment-request-button" style="margin-top: 30px">결제하기</button>			    
			    </c:if>
		    </div>
		</div>
		<c:if test="${ member.status eq 0 }">
			<a href="/product/update?productNum=${ product.productNum }" class="btn btn-warning">수정</a>	
			<form id="frm" action="/product/delete" method="post">
				<input type="hidden" name="productNum" value=${ product.productNum }>
			</form>
			<button type="submit" class="btn btn-danger delete">삭제</button>			
		</c:if>
		<a href="/product/list" class="btn btn-primary">상품 목록</a>
		<input type="hidden" name="productNum" class="productNum" value=${ product.productNum }>
		<input type="hidden" class="memberName" value=${ sessionScope.member.name }>
		<input type="hidden" class="memberPhone" value=${ sessionScope.member.phone }>
		<input type="hidden" class="memberEmail" value=${ sessionScope.member.email }>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	<script type="text/javascript" src="/js/pay/payment.js"></script>
	<script type="text/javascript" src="/js/product/product.js"></script>
</body>
</html>