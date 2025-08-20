package com.winter.app.member;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	
	private int birthYear;
	private int birthMonth;
	private int birthDay;
	
	@NotBlank(message = "id는 필수로 입력해야 합니다")
	@DecimalMin(value="6" ,message = "id는 최소 6자 이상이어야 합니다")
	private String id;
	@NotBlank(message = "pw는 필수로 입력해야 합니다")
	@DecimalMin(value="8", message = "pw는 최소 8자 이상이어야 합니다")
	private String pw;
	@NotBlank(message = "이름은 필수로 입력해야 합니다")
	@DecimalMin(value="2", message = "이름은 최소 2자 이상이어야 합니다")
	private String name;
	@NotBlank(message = "email은 필수로 입력해야 합니다")
	@Email
	private String email;
	@NotBlank(message = "전화번호는 필수로 입력해야 합니다")
	private String phone;
	@NotNull(message = "생년월일은 필수로 입력해야 합니다")
	@Past
	private LocalDate birth;
	private int status;
	
	public void setBirthDate() {
		birth = LocalDate.of(birthYear, birthMonth, birthDay);
	}
	
}


