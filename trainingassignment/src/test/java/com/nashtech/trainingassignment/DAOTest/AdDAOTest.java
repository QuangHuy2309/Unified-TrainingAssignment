package com.nashtech.trainingassignment.DAOTest;

import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.nashtech.trainingassignment.DAO.AdDAO;
import com.nashtech.trainingassignment.model.Ad;

public class AdDAOTest {
//	AdDAO adDAO = AdDAO.getInstance();
	
	@Mock
	AdDAO adDAO = AdDAO.getInstance();;
	
//	@BeforeAll
//	public static void setup() {
//		adDAO = AdDAO.getInstance();
//	}
	
	@Test
	void getInstance() {
		AdDAO adDAO1 = AdDAO.getInstance();
		AdDAO adDAO2 = AdDAO.getInstance();
		assertEquals(adDAO1, adDAO2);
	}
	
//	@Test
//	void saveDataSuccessTest() {
//		Ad ad1 = new Ad("Camp_id_1", "advertiser_id_1", "campaign_name_1", "ad_id_1", "ad_name_1", "ad_text_1",
//				"ad_format_1", "adgroup_id_1", "adgroup_name_1", "status_1", "otp_status_1", "appname_1");
//		Ad ad2 = new Ad("Camp_id_2", "advertiser_id_2", "campaign_name_2", "ad_id_2", "ad_name_2", "ad_text_2",
//				"ad_format_2", "adgroup_id_2", "adgroup_name_2", "status_2", "otp_status_2", "appname_2");
//		Ad ad3 = new Ad("Camp_id_3", "advertiser_id_3", "campaign_name_3", "ad_id_3", "ad_name_3", "ad_text_3",
//				"ad_format_3", "adgroup_id_3", "adgroup_name_3", "status_3", "otp_status_3", "appname_3");
//
//		ArrayList<Ad> listAd = new ArrayList<Ad>();
//		listAd.add(ad1);
//		listAd.add(ad2);
//		listAd.add(ad3);
//		when(adDAO.saveData(listAd)).thenReturn("Save Ad data success");
//		String result = adDAO.saveData(listAd);
//		assertEquals(result,"Save Ad data success");
//	}

}
