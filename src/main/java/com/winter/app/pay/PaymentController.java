package com.winter.app.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.winter.app.member.MemberVO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/payment/*")
@Controller
public class PaymentController {
	
	@Autowired
	private IamportClient iamportClient;
	
	@Autowired
	private PaymentService paymentService;
    
    @PostMapping("order")
    @ResponseBody
    public PaymentLogVO insertProductLog(HttpSession session, PaymentLogVO paymentLogVO) {
    	MemberVO memberVO = (MemberVO)session.getAttribute("member");
    	paymentLogVO.setId(memberVO.getId());
    	int result = paymentService.insertProductLog(paymentLogVO);
    	if (result > 0) {
    		paymentLogVO = paymentService.getProductLog(paymentLogVO);
    		return paymentLogVO;
    	} else {
    		return null;
    	}
    }
    
    @PostMapping("cancelPayment")
    @ResponseBody
    public boolean cancelPayment(PaymentLogVO paymentLogVO) {
    	int result = paymentService.cancelPayment(paymentLogVO);
    	if (result > 0) return true;
    	else return false;
    }
    
    @PostMapping("confirmPayment")
    @ResponseBody
    public boolean confirmPayment(PaymentLogVO paymentLogVO) {
    	int result = paymentService.confirmPayment(paymentLogVO);
    	if (result > 0) return true;
    	else return false;
    }
    
    
    @PostMapping("verifyPayment")
    @ResponseBody
    public Payment verifyPayment(@RequestBody PaymentRequestVO request) throws Exception {
    	
        IamportResponse<Payment> response = iamportClient.paymentByImpUid(request.getImp_uid());
        Payment payment = response.getResponse();
        PaymentLogVO paymentLogVO = new PaymentLogVO();
        paymentLogVO.setLogNum(payment.getMerchantUid());

        // DB에서 결제 주문의 결제 상품의 금액을 가져옴 -> 이거를 이제 실제 결제된 금액이랑 비교해서 검증하는거임 ㅇㅇ
        long orderAmount = paymentService.getProductLog(paymentLogVO).getProductVO().getProductPrice();
  	
        if (payment.getAmount().longValue() == orderAmount) {
        	return payment; // 성공 시 결제 정보 리턴
        } else {
            // 금액이 불일치할 때 결제 취소기켜버리기
            CancelData cancelData = new CancelData(
                request.getImp_uid(),  // 취소할 imp_uid
                true                   // imp_uid 기준으로 취소 여부
            );
            // 만약 취소 response를 쓸 일이 있으면 사용
            // IamportResponse<Payment> cancelResponse = iamportClient.cancelPaymentByImpUid(cancelData); 
            iamportClient.cancelPaymentByImpUid(cancelData);
        	throw new RuntimeException("결제 금액 불일치");
        }
    }
	
}
