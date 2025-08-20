package com.winter.app.pay;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDAO {

	int insertProductLog(PaymentLogVO paymentLogVO);

	PaymentLogVO getProductLog(PaymentLogVO paymentLogVO);

	int cancelPayment(PaymentLogVO paymentLogVO);

	int confirmPayment(PaymentLogVO paymentLogVO);

}
