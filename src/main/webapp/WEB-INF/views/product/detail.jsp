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
			    <button class="button btn btn-primary" id="payment-request-button" style="margin-top: 30px">결제하기</button>
		    </div>
		</div>
		<a href="/product/list" class="btn btn-primary">상품 목록</a>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	
	<script type="text/javascript">
		IMP.init("imp68337458");
		
		const pay = document.querySelector('#payment-request-button');
		
		pay.addEventListener('click', requestPay)
		
		function requestPay() {
			  IMP.request_pay({
			      pg: "html5_inicis",
			      pay_method: "card",
			      merchant_uid: "order_" + new Date().getTime(),
			      name: "테스트 결제",
			      amount: 1000,
			      buyer_email: "test@example.com",
			      buyer_name: "홍길동",
			      buyer_tel: "010-1234-5678",
			      buyer_addr: "서울특별시 강남구",
			      buyer_postcode: "123-456"
			  }, function (rsp) {
			      if (rsp.success) {
			          // 성공 시 서버에 imp_uid 전달 → 서버에서 검증
			          fetch("/verifyPayment", {
			              method: "POST",
			              headers: { "Content-Type": "application/json" },
			              body: JSON.stringify({ imp_uid: rsp.imp_uid })
			          })
			          .then(res => res.json())
			          .then(payment => {
			        	    alert("결제 완료! 금액: " + payment.amount);
			        	    console.log(payment)
			        	})
			        	.catch(err => alert("결제 검증 실패: " + err));
			      } else {
			          alert("결제 실패: " + rsp.error_msg);
			      }
			  });
			}
	</script>
</body>
</html>