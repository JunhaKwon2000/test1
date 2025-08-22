package com.winter.app.product;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	
	private Long productNum;
	@NotNull(message = "상품 종류를 선택해주세요")
	private Long kindNum;
	@NotBlank(message = "상품 이름을 입력해주세요")
	private String productName;
	@NotBlank(message = "상품 상세 설명을 입력해주세요")
	private String productContent;
	@NotNull(message = "상품 판매 기간을 입력해주세요")
	@Future(message = "상품 판매 기간은 오늘 이후 날짜만 가능합니다")
	private LocalDate productDate;
	@NotNull(message = "상품 가격을 입력해주세요")
	@Positive(message = "상품 가격은 양수만 가능합니다")
	private Long productPrice;
	private Long productStatus;
	
	private ProductKindVO productKindVO;
	private ProductFileVO productFileVO;
	
}
