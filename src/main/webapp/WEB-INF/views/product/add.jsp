<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div class="col-md-4 offset-md-4 mt-5">
		<h1 class="h3 mb-4 text-gray-800">상품 등록</h1>
		<form:form method="post" enctype="multipart/form-data"  modelAttribute="productVO">
			<div class="mb-4">
				<label for="productName" class="form-label">상품명</label>
				<input type="text" class="form-control" id="productName" name="productName" value="${ product.productName }">
				<form:errors path="productName" style="color: red;"></form:errors>
			</div>
			<div class="mb-4">
				<label for="productDate" class="form-label">판매 기간</label>
				<input type="date" class="form-control" id="productDate" name="productDate" value="${ product.productDate }">
				<form:errors path="productDate" style="color: red;"></form:errors>
			</div>
			<div class="mb-4">
				<label for="productContent" class="form-label">상세 설명</label>
				<textarea class="form-control" id="productContent" name="productContent" style="height: 100px; resize: none;">${ product.productContent }</textarea>
				<form:errors path="productContent" style="color: red;"></form:errors>
			</div>
			<div class="mb-4">
				<label for="productPrice" class="form-label">상품 가격</label>
				<input type="number" class="form-control" id="productPrice" name="productPrice" step="1000" value="${ product.productPrice }">
				<form:errors path="productPrice" style="color: red;"></form:errors>
			</div>
			<div class="input-group mb-3">
				<input type="file" class="form-control" id="inputGroupFile02" name="productImg">
			</div>
			<div class="d-flex justify-content-between">
				<div>
					<c:if test="${ product.kindNum eq 1 }">
						<input class="form-check-input" type="radio" name="kindNum" id="radioDefault1" value="1" checked="checked">								
						<label class="form-check-label" for="radioDefault1">액세서리</label>
					</c:if>
					<c:if test="${ product.kindNum ne 1 }">
						<input class="form-check-input" type="radio" name="kindNum" id="radioDefault1" value="1">								
						<label class="form-check-label" for="radioDefault1">액세서리</label>
					</c:if>
				</div>
				<div>
					<c:if test="${ product.kindNum eq 2 }">
						<input class="form-check-input" type="radio" name="kindNum" id="radioDefault2" value="2" checked="checked">																
						<label class="form-check-label" for="radioDefault2">의류</label>
					</c:if>
					<c:if test="${ product.kindNum ne 2 }">
						<input class="form-check-input" type="radio" name="kindNum" id="radioDefault2" value="2">																
						<label class="form-check-label" for="radioDefault2">의류</label>
					</c:if>
				</div>
				<div>
					<c:if test="${ product.kindNum eq 3 }">					
						<input class="form-check-input" type="radio" name="kindNum" id="radioDefault3" value="3" checked="checked">
						<label class="form-check-label" for="radioDefault3">텀블러</label>
					</c:if>
					<c:if test="${ product.kindNum ne 3 }">
						<input class="form-check-input" type="radio" name="kindNum" id="radioDefault3" value="3">
						<label class="form-check-label" for="radioDefault3">텀블러</label>
					</c:if>
				</div>
				<div>
					<c:if test="${ product.kindNum eq 4 }">
						<input class="form-check-input" type="radio" name="kindNum" id="radioDefault4" value="4" checked="checked">
						<label class="form-check-label" for="radioDefault4">소품</label>
					</c:if>
					<c:if test="${ product.kindNum ne 4 }">
						<input class="form-check-input" type="radio" name="kindNum" id="radioDefault4" value="4">
						<label class="form-check-label" for="radioDefault4">소품</label>
					</c:if>
				</div>
			</div>
			<form:errors path="kindNum" style="color: red;"></form:errors>
			<div class="d-grid mt-5">
				<c:if test="${ product eq null }">
					<button class="btn btn-primary" type="submit">상품등록</button>
				</c:if>
				<c:if test="${ product ne null }">
					<button class="btn btn-primary" type="submit">상품수정</button>				
				</c:if>
			</div>
		</form:form>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>