package com.winter.app.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.winter.app.member.MemberVO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/payment/*")
@Controller
public class PaymentController {
	
	private final IamportClient iamportClient;
	
	@Autowired
	private PaymentService paymentService;
	
    public PaymentController(IamportClient iamportClient) {
        this.iamportClient = iamportClient;
    }
    
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
    public Payment verifyPayment(@RequestBody PaymentRequest request) throws Exception {
        IamportResponse<Payment> response = iamportClient.paymentByImpUid(request.getImp_uid());
        Payment payment = response.getResponse();
        PaymentLogVO paymentLogVO = new PaymentLogVO();
        paymentLogVO.setLogNum(payment.getMerchantUid());

        // DB 조회
        long orderAmount = paymentService.getProductLog(paymentLogVO).getProductVO().getProductPrice();

        if (payment.getAmount().longValue() == orderAmount) {
            return payment; // 성공 시 결제 정보 리턴
        } else {
            throw new IllegalStateException("결제 금액 불일치");
        }
    }

    // imp_uid 받아올 DTO
    public static class PaymentRequest {
        private String imp_uid;
        public String getImp_uid() { return imp_uid; }
        public void setImp_uid(String imp_uid) { this.imp_uid = imp_uid; }
    }
	
}
