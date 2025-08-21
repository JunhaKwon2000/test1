package com.winter.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.common.FileManager;


@Service
public class MemberService {
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Value("${app.upload}")
	private String upload;

	@Value("${type.profile}")
	private String type;
	
	
	public int join(MemberVO memberVO, MultipartFile profile)throws Exception{
		int result =  memberDAO.join(memberVO);
		
		String fileName = fileManager.fileSave(upload + type, profile);
		
		ProfileVO profileVO = new ProfileVO();
		profileVO.setOriName(profile.getOriginalFilename());
		profileVO.setSaveName(fileName);
		profileVO.setId(memberVO.getId());
		result = memberDAO.addFile(profileVO);
		
		return result;
	}

	public MemberVO login(MemberVO memberVO)throws Exception {
		MemberVO checkVO = memberDAO.login(memberVO);
		
		if(checkVO != null && memberVO.getPw().equals(checkVO.getPw())) {
			return checkVO;
		}
		
		return null;
	}

	public boolean checkPassword(String memberId, String currentPassword)throws Exception {
		MemberVO vo = new MemberVO();
		
		
		
		String dbPw = memberDAO.getPassword(vo);
		
		if(dbPw == null) {
			return false;
		}
		
		return currentPassword.equals(dbPw);
	}

	public int updatePassword(String memberId, String newPassword)throws Exception {
		MemberVO vo = new MemberVO();
		vo.setId(memberId);
		vo.setPw(newPassword);
		return memberDAO.updatePassword(vo);
		
	}

	

	public int updateMember(MemberVO memberVO) throws Exception {
		
		return memberDAO.memberChange(memberVO);
	}

	public MemberVO getProfile(MemberVO memberVO) {
		
		return memberDAO.getProfile(memberVO);
	}
	

}
