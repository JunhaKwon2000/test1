package com.winter.app.donation;

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
import com.winter.app.pay.PaymentRequestVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/donation/*")
public class DonationController {
	@Autowired
	private IamportClient iamportClient;

	@Autowired
	private DonationService donationService;
	
	@PostMapping("order")
    @ResponseBody
    public DonationLogVO insertProductLog(HttpSession session) {
    	MemberVO memberVO = (MemberVO)session.getAttribute("member");
    	DonationLogVO donationLogVO = new DonationLogVO();
    	donationLogVO.setId(memberVO.getId());
    	int result = donationService.insertDonationLog(donationLogVO);
    	if (result > 0) {
    		donationLogVO = donationService.getDonationLog(donationLogVO);
    		return donationLogVO;
    	} else {
    		return null;
    	}
    }
	
	@PostMapping("cancelPayment")
    @ResponseBody
    public boolean cancelPayment(DonationLogVO donationLogVO) {
    	int result = donationService.cancelPayment(donationLogVO);
    	if (result > 0) return true;
    	else return false;
    }
    
    @PostMapping("confirmPayment")
    @ResponseBody
    public boolean confirmPayment(DonationLogVO donationLogVO) {
    	int result = donationService.confirmPayment(donationLogVO);
    	if (result > 0) return true;
    	else return false;
    }
    
    @PostMapping("verifyPayment")
    @ResponseBody
    public Payment verifyPayment(@RequestBody PaymentRequestVO request) throws Exception {
        IamportResponse<Payment> response = iamportClient.paymentByImpUid(request.getImp_uid());
        Payment payment = response.getResponse();
        

        // DB 조회
        long orderAmount = 5000;

        if (payment.getAmount().longValue() == orderAmount) {
            return payment; // 성공 시 결제 정보 리턴
        } else {
            throw new IllegalStateException("결제 금액 불일치");
        }
    }
	
}
