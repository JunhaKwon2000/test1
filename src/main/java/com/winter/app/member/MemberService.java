package com.winter.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public int join(MemberVO memberVO, MultipartFile profile)throws Exception{
		int result =  memberDAO.join(memberVO);
		
		
		
		return result;
	}

	public MemberVO login(MemberVO memberVO)throws Exception {
		MemberVO checkVO = memberDAO.login(memberVO);
		
		if(checkVO != null && memberVO.getPw().equals(checkVO.getPw())) {
			return checkVO;
		}
		
		return null;
	}
	

}
