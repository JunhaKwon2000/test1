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
				<input type="text" class="form-control" id="productName" name="productName">
			</div>
			<div class="mb-4">
				<label for="productDate" class="form-label">판매 기간</label>
				<input type="date" class="form-control" id="productDate" name="productDate">
			</div>
			<div class="mb-4">
				<label for="productContent" class="form-label">상세 설명</label>
				<textarea class="form-control" id="productContent" name="productContent" style="height: 100px; resize: none;" ></textarea>
			</div>
			<div class="mb-4">
				<label for="productPrice" class="form-label">상품 가격</label>
				<input type="number" class="form-control" id="productPrice" name="productPrice" step="1000">
			</div>
			<div class="input-group mb-3">
				<input type="file" class="form-control" id="inputGroupFile02" name="productImg">
			</div>
			<div class="d-flex justify-content-between">
				<div>
					<input class="form-check-input" type="radio" name="kindNum" id="radioDefault1" value="1">								
					<label class="form-check-label" for="radioDefault1">액세서리</label>
				</div>
				<div>
					<input class="form-check-input" type="radio" name="kindNum" id="radioDefault2" value="2">																
					<label class="form-check-label" for="radioDefault2">의류</label>
				</div>
				<div>								
					<input class="form-check-input" type="radio" name="kindNum" id="radioDefault3" value="3">
					<label class="form-check-label" for="radioDefault3">텀블러</label>
				</div>
				<div>								
					<input class="form-check-input" type="radio" name="kindNum" id="radioDefault4" value="4">
					<label class="form-check-label" for="radioDefault4">소품</label>
				</div>
			</div>
			<div class="d-grid mt-5">
				<button class="btn btn-primary" type="submit">상품등록</button>
			</div>
		</form:form>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>