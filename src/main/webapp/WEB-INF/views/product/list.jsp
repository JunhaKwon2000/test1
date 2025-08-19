<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="col-md-8 offset-md-2 mt-5">
		<div class="d-flex flex-wrap justify-content-start">
			<c:forEach items="${ list }" var="product">
				<div class="card m-2" style="width: 23%;">
				 	<div class="bg-light rounded" 
					     style="background-image: url('/files/product/${ product.productFileVO.saveName }');
					            background-size: cover;
					            background-position: center;
					            width: 100%;
					            height: 200px;">
					</div>
				    <div class="card-body">
					    <h5 class="card-title">${ product.productName }</h5>
					    <p class="card-text">${ product.productContent }</p>
					    <p class="card-text">상품 종류: ${ product.productKindVO.kindName }</p>
					    <p class="card-text">${ product.productPrice }원</p>
					    <a href="./detail?productNum=${ product.productNum }" class="btn btn-primary">상세보기</a>
				    </div>
				</div>
			</c:forEach>
		</div>
		<a href="/product/add" class="btn btn-primary">상품 등록</a>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>