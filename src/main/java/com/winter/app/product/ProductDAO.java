package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.common.KeywordVO;

@Mapper
public interface ProductDAO {

	int add(ProductVO productVO);

	List<ProductVO> getProductList(KeywordVO keywordVO);

	int addFile(ProductFileVO productFileVO);

	ProductVO getProductByNum(ProductVO productVO);

	int update(ProductVO productVO);

	int delete(ProductVO productVO);

}
