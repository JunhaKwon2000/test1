package com.winter.app.product;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	
	private Long productNum;
	private Long kindNum;
	private String productName;
	private String productContent;
	private LocalDate productDate;
	private Long productPrice;
	
	private ProductKindVO productKindVO;
	private ProductFileVO productFileVO;
	
}
