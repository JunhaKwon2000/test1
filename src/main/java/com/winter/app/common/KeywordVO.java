package com.winter.app.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KeywordVO {
	
	private Long kind;
	private String keyword;
	
	public String getKeyword() {
		if (this.keyword == null) this.keyword = "";
		return this.keyword;
	}
	
}
