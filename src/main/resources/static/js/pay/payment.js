/**
 * 
 */
IMP.init("imp68337458");
	
const pay = document.querySelector('#payment-request-button');
const productNum = document.querySelector('.productNum');
let params = new URLSearchParams();
params.append("productNum", productNum.value);

pay.addEventListener('click', () => {
    // 1. 주문 생성 요청
    fetch("/payment/order", {
        method: "POST",
        body: params
    })
    .then(res => res.json())
    .then(paymentLogVO => {
        // 2. 서버에서 응답받은 merchant_uid, amount 사용
        let name = document.querySelector('.memberName').value;
        console.log(name)
        let phone = document.querySelector('.memberPhone').value;
        let email = document.querySelector('.memberEmail').value;
 
        IMP.request_pay({
            pg: "html5_inicis",
            pay_method: "card",
            merchant_uid: paymentLogVO.logNum,
            name: paymentLogVO.productVO.productName,
            amount: paymentLogVO.productVO.productPrice,
            buyer_name: name,
            buyer_tel: phone,
            buyer_email: email
        }, function (rsp) {
            if (rsp.success) {
                // 3. 결제 성공 → 서버에 imp_uid 검증 요청
                fetch("/payment/verifyPayment", {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify({ imp_uid: rsp.imp_uid })
                })
                .then(res => res.json())
                .then(payment => {
                	let payParam = new URLSearchParams();
            		payParam.append("logNum", paymentLogVO.logNum);
                    fetch("/payment/confirmPayment", {
	                    method: "POST",
	                    body: payParam
	                })
	                .then(res => res.json())
	                .then(res => { console.log(res) })
                	
                    alert("결제가 완료되었습니다. 금액: " + paymentLogVO.productVO.productPrice);
                })
                .catch(err => {
                	let errParam = new URLSearchParams();
            		errParam.append("logNum", paymentLogVO.logNum);
                    fetch("/payment/cancelPayment", {
	                    method: "POST",
	                    body: errParam
	                })
	                .then(res => res.json())
	                .then(res => { console.log(res) })
	                
                	alert("결제 검증 실패: " + err)
                	});
            } else {
            	let cancelParam = new URLSearchParams();
        		cancelParam.append("logNum", paymentLogVO.logNum);
                fetch("/payment/cancelPayment", {
                    method: "POST",
                    body: cancelParam
                })
                .then(res => res.json())
                .then(res => { console.log(res) })
                
                alert("결제 실패: " + rsp.error_msg);
            }
        });
    })
    .catch(err => alert("주문 생성 실패: " + err));
});