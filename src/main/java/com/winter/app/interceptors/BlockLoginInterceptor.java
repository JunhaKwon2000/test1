package com.winter.app.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.winter.app.member.MemberDAO;
import com.winter.app.member.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BlockLoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			boolean flag = false;
			if("GET".equalsIgnoreCase(request.getMethod())) {
				flag = true;
			}
			else if ("POST".equalsIgnoreCase(request.getMethod())) {
		        // Your logic for POST requests
			MemberVO memberVO = new MemberVO();
			memberVO.setId(request.getParameter("id"));
			memberVO.setPw(request.getParameter("pw"));
			
			MemberVO result = memberDAO.login(memberVO);
			if(result == null) {
				flag = true;
			} else {
				
				if(result.getDeleteStatus()==0) {
					request.setAttribute("msg", "로그인 실패");
					request.setAttribute("url", "/");
					request.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(request, response);
				} else {
					flag = true;
				}
			}
			
		}
			return flag;
	}
}
