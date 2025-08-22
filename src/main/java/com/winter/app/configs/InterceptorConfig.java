package com.winter.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.winter.app.interceptors.BlockLoginInterceptor;
import com.winter.app.interceptors.CheckLoginInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private CheckLoginInterceptor checkLoginInterceptor;
	
	@Autowired
	private BlockLoginInterceptor blockLoginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(checkLoginInterceptor)
				.addPathPatterns("/member/mypage", "/member/update", "/member/passwordChange");
		registry.addInterceptor(blockLoginInterceptor).addPathPatterns("/member/login");
	}
	
}
