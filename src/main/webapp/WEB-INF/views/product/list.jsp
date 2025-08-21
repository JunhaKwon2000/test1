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
			<form method="get" class="input-group mb-3">
				<select class="form-select" id="inputGroupSelect02" name="kind">
		    		<option value='' selected>상품 종류</option>
			    	<option value="1">액세서리</option>
			    	<option value="2">의류</option>
			    	<option value="3">텀블러</option>
			    	<option value="4">소품</option>
				</select>
				<input type="text" class="form-control" placeholder="검색어를 입력하세요" name="keyword">
				<button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
			</form>
			<c:forEach items="${ list }" var="product">
				<c:if test="${ product.productStatus eq 0 }">
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
				</c:if>
			</c:forEach>
		</div>
		<c:if test="${ member.status eq 0 }">
			<a href="/product/add" class="btn btn-primary">상품 등록</a>
		</c:if>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>