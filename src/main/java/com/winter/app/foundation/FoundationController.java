package com.winter.app.foundation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/foundation/*")
@Controller
public class FoundationController {
	
	@GetMapping("list")
	public String foundationList() {
		return "/foundation/list";
	}
	
}
