package com.winter.app.member;

import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	
	@Min(1920) @Max(2100)
	private int birthYear;
	
	@Min(1) @Max(12)
	private int birthMonth;
	
	@Min(1) @Max(31)
	private int birthDay;
	
	@NotBlank(message = "id는 필수로 입력해야 합니다")
	@Size(min=6, max=12,message = "id는 최소 6자 이상이어야 합니다")
	private String id;
	@NotBlank(message = "pw는 필수로 입력해야 합니다")
	@Size(min=8, max=13,message = "pw는 최소 8자 이상이어야 합니다")
	private String pw;
	@NotBlank(message = "이름은 필수로 입력해야 합니다")
	@Size(min=2, max=20,message = "이름은 최소 2자 이상이어야 합니다")
	private String name;
	@NotBlank(message = "email은 필수로 입력해야 합니다")
	@Email
	@Pattern(regexp = "/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$/i\r\n", message="올바르지 않은 이메일 형식입니다")
	private String email;
	@NotBlank(message = "전화번호는 필수로 입력해야 합니다")
	@Pattern(regexp = "/^0\\d{1,2}-?\\d{3,4}-?\\d{4}$" ,message="올바르지 않은 전화번호 형식입니다")
	private String phone;
	private LocalDate birth;
	private int status;
	private int deleteStatus;
	private ProfileVO profileVO;
	
	public void setBirthDate() {
		if (birthYear <= 0 || birthMonth < 1 || birthMonth > 12 || birthDay <= 0) {
	        this.birth = null; // 잘못된 값이면 null 처리
	    } else {
	        birth = LocalDate.of(birthYear, birthMonth, birthDay);
	    }
	}
	
}


