package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/product/*")
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public String list(Model model) {
		List<ProductVO> result = productService.getProductList();
		model.addAttribute("list", result);
		return "/product/list";
	}
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("productVO", new ProductVO());
		return "/product/add";
	}
	
	@PostMapping("add")
	public String add(ProductVO productVO, MultipartFile productImg, Model model) throws Exception {
		int result = productService.add(productVO, productImg);
		
		String msg = "상품 등록에 실패했습니다";
		String url = "./list";
		if (result > 0) msg = "상품이 등록되었습니다.";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "common/result";
	}
	
	@GetMapping("detail")
	public String detail(ProductVO productVO, Model model) {
		ProductVO result = productService.getProductByNum(productVO);
		model.addAttribute("product", result);
		return "/product/detail";
	}
	
}
