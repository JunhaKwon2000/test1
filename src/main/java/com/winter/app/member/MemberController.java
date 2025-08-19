package com.winter.app.member;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;



@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@GetMapping("join")
	public String memberJoin() {
		return "/member/join";
	}
	
	@PostMapping("/member/joinProc")
	public String joinProc(@Valid MemberVO memberVO, BindingResult bingdingResult, MultipartFile multipartFile)throws Exception {
		
		
		return "redirect:/";
	}
	
	@GetMapping("login")
	public String memberLogin() {
		return "/member/login";
	}
}
