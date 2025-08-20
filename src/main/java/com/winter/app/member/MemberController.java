package com.winter.app.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;



@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("join")
	public String memberJoin() {
		return "/member/join";
	}
	
	@PostMapping("join")
	public String join(@Valid MemberVO memberVO, BindingResult bingdingResult, MultipartFile profile)throws Exception {
		
		memberVO.setBirthDate();
		
		int result = memberService.join(memberVO, profile);
		
		return "/member/login";
	}
	
	@GetMapping("login")
	public void memberLogin() {
		
	}
	
	@PostMapping("login")
	public String login(MemberVO memberVO, HttpSession session, RedirectAttributes redirectAttributes)throws Exception {
		
		MemberVO loginVO = memberService.login(memberVO);
		
		if(loginVO != null) {
			session.setAttribute("member",loginVO);
			return "redirect:/";
		} else {
			redirectAttributes.addFlashAttribute("errorMessage","아이디 또는 비밀번호가 올바르지 않습니다.");
			return "redirect:/member/login";
		}
		
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 전체 삭제
		return "redirect:/";
		
	}
	
	@GetMapping("mypage")
	public void mypage() {
		
	}
	
	@GetMapping("passwordChange")
	public String passwordChangePage() {
		return "/member/passwordChange";
	}
	
	@PostMapping("changePassword")
	public String changePassword(
			String currentPassword,
			String newPassword,
			String confirmPassword,
			HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception{
		
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		if(member == null) {
			redirectAttributes.addFlashAttribute("errorMessage","로그인 후 이용해주세요.");
			return "redirect:/member/login";
		}
		
	// 1) 새 비밀번호 확인
		if(!newPassword.equals(confirmPassword)) {
			redirectAttributes.addFlashAttribute("errorMessage", "새 비밀번호가 일치하지 않습니다");
			return "redirect:/member/passwordChange";
			
		}
	// 2) 현재 비밀번호 검증
		
		if(!member.getPw().equals(currentPassword)) {
			redirectAttributes.addFlashAttribute("errorMessage","현재 비밀번호가 올바르지 않습니다.");
			return "redirect:/member/passwordChange";
		}
		
	// 3) 비밀번호 변경
	memberService.updatePassword(member.getId(), newPassword);
	// 세션 무효화
	redirectAttributes.addFlashAttribute("successMessage","비밀번호가 성공적으로 변경되었습니다. 다시 로그인 해주세요");
	session.invalidate();
	return "redirect:/member/login";		 
	
	
	
	}
	
	
	
	
}
