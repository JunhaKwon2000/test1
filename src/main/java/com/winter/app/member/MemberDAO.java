package com.winter.app.member;



public interface MemberDAO {
	
	public MemberVO login(MemberVO memberVO)throws Exception;
	
	public int join(MemberVO memberVO)throws Exception;
}
