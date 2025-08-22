package com.winter.app.pay;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentDAO paymentDAO;

	public int insertProductLog(PaymentLogVO paymentLogVO) {
		String uid = "order_" + System.currentTimeMillis() + "_" + paymentLogVO.getId();
		paymentLogVO.setLogNum(uid);
		int result = paymentDAO.insertProductLog(paymentLogVO);
		return result;
	}

	public PaymentLogVO getProductLog(PaymentLogVO paymentLogVO) {
		return paymentDAO.getProductLog(paymentLogVO);
	}

	public int cancelPayment(PaymentLogVO paymentLogVO) {
		return paymentDAO.cancelPayment(paymentLogVO);
	}

	public int confirmPayment(PaymentLogVO paymentLogVO) {
		return paymentDAO.confirmPayment(paymentLogVO);
	}
	
}
