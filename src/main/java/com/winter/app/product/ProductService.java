package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.common.FileManager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload}")
	private String upload;
	
	@Value("${type.product}")
	private String type;

	public int add(ProductVO productVO, MultipartFile productImg) throws Exception {
		int result = productDAO.add(productVO);
		
		String fileName = fileManager.fileSave(upload + type, productImg);
		
		ProductFileVO productFileVO = new ProductFileVO();
		productFileVO.setOriName(productImg.getOriginalFilename());
		productFileVO.setSaveName(fileName);
		productFileVO.setProductNum(productVO.getProductNum());
		result = productDAO.addFile(productFileVO);
		
		return result;
	}

	public List<ProductVO> getProductList() {
		List<ProductVO> result = productDAO.getProductList();
		return result;
	}

	public ProductVO getProductByNum(ProductVO productVO) {
		ProductVO result = productDAO.getProductByNum(productVO);
		return result;
	}

	public int update(ProductVO productVO) {
		int result = productDAO.update(productVO);
		return result;
	}

	public int delete(ProductVO productVO) {
		int result = productDAO.delete(productVO);
		return result;
	}

}
