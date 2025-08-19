package com.winter.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;



public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public int join(MemberVO memberVO, MultipartFile multipartFile)throws Exception{
		int result =  memberDAO.join(memberVO);
		
		return result;
	}
	
//	public MemberVO login()throws Exception{
//		
//	}
}
