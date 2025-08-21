package com.winter.app.donation;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonationDAO {

	int insertDonationLog(DonationLogVO donationLogVO);

	DonationLogVO getDonationLog(DonationLogVO donationLogVO);

	int cancelPayment(DonationLogVO donationLogVO);

	int confirmPayment(DonationLogVO donationLogVO);
	
}
