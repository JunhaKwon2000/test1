package com.winter.app.donation;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DonationLogVO {
	private String logNum;
	private String id;
	private LocalDateTime logDate;
	private String status;
}
