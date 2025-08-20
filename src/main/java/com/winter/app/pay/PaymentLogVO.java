package com.winter.app.pay;

import java.time.LocalDateTime;

import com.winter.app.product.ProductVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentLogVO {
	
	private String logNum;
	private String id;
	private Long productNum;
	private LocalDateTime logDate;
	private String status;
	
	private ProductVO productVO;

}
