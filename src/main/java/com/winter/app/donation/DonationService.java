package com.winter.app.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService {
	@Autowired
	private DonationDAO donationDAO;

	public int insertDonationLog(DonationLogVO donationLogVO) {
		String uid = "order_" + System.currentTimeMillis() + "_" + donationLogVO.getId();
		donationLogVO.setLogNum(uid);
		int result = donationDAO.insertDonationLog(donationLogVO);
		return result;
	}

	public DonationLogVO getDonationLog(DonationLogVO donationLogVO) {
		// TODO Auto-generated method stub
		return donationDAO.getDonationLog(donationLogVO);
	}

	public int cancelPayment(DonationLogVO donationLogVO) {
		return donationDAO.cancelPayment(donationLogVO);
		
	}

	public int confirmPayment(DonationLogVO donationLogVO) {
		return donationDAO.confirmPayment(donationLogVO);
	}

}
