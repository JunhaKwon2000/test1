package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.common.KeywordVO;

import jakarta.validation.Valid;

@RequestMapping("/product/*")
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public String list(KeywordVO keywordVO, Model model) {
		List<ProductVO> result = productService.getProductList(keywordVO);
		model.addAttribute("list", result);
		model.addAttribute("keyword", keywordVO);
		return "/product/list";
	}
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("productVO", new ProductVO());
		return "/product/add";
	}
	
	@PostMapping("add")
	public String add(@Valid ProductVO productVO, BindingResult bindingResult, MultipartFile productImg, Model model) throws Exception {
		if (bindingResult.hasErrors()) {
			return "/product/add";
		}
		
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
	
	@GetMapping("update")
	public String update(ProductVO productVO, Model model) {
		ProductVO result = productService.getProductByNum(productVO);
		model.addAttribute("product", result);
		return "/product/add";
	}
	
	@PostMapping("update")
	public String update(ProductVO productVO, MultipartFile productImg, Model model) throws Exception {
		int result = productService.update(productVO);
		String msg = "상품 수정에 실패했습니다";
		String url = "./detail?productNum=" + productVO.getProductNum();
		if (result > 0) msg = "상품이 수정되었습니다.";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "common/result";
	}
	
	@PostMapping("delete")
	public String delete(ProductVO productVO, Model model) {
		int result = productService.delete(productVO);
		
		String msg = "상품 삭제에 실패했습니다";
		String url = "/product/list";
		if (result > 0) msg = "상품이 삭제되었습니다.";
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "common/result";
	}
	
}
