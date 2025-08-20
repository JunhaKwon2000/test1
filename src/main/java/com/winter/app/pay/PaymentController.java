package com.winter.app.pay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
public class PaymentController {
	
	private final IamportClient iamportClient;
	
    public PaymentController(IamportClient iamportClient) {
        this.iamportClient = iamportClient;
    }
    
    // 프론트에서 imp_uid 전달받아서 검증
    @PostMapping("/verifyPayment")
    @ResponseBody
    public Payment verifyPayment(@RequestBody PaymentRequest request) throws Exception {
        IamportResponse<Payment> response = iamportClient.paymentByImpUid(request.getImp_uid());
        Payment payment = response.getResponse();

        // 여기서 DB 주문 금액 조회 (예시로 1000원 고정)
        int orderAmount = 1000;

        if (payment.getAmount().intValue() == orderAmount) {
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
