<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
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
			    <button class="button btn btn-primary" id="payment-request-button" style="margin-top: 30px">결제하기</button>
		    </div>
		</div>
		<a href="/product/list" class="btn btn-primary">상품 목록</a>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>