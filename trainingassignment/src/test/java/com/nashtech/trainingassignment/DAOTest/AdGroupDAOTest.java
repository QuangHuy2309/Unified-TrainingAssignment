package com.nashtech.trainingassignment.DAOTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nashtech.trainingassignment.dao.AdGroupDAO;
import com.nashtech.trainingassignment.model.AdGroup;


public class AdGroupDAOTest {
	@Test
	void getInstance() {
		AdGroupDAO adGrDAO1 = AdGroupDAO.getInstance();
		AdGroupDAO adGrDAO2 = AdGroupDAO.getInstance();
		assertEquals(adGrDAO1, adGrDAO2);
	}
	@Test
	void saveDataSuccessTest() {
		AdGroupDAO adGrpDAO =Mockito.mock(AdGroupDAO.class);
		AdGroup adgrp1 = new AdGroup("Camp_id_1", "advertiser_id_1", "campaign_name_1", "adgroup_id_1", 
				"adgroup_name_1");
		AdGroup adgrp2 = new AdGroup("Camp_id_2", "advertiser_id_2", "campaign_name_2", "adgroup_id_2", 
				"adgroup_name_2");
		AdGroup adgrp3 = new AdGroup("Camp_id_3", "advertiser_id_3", "campaign_name_3", "adgroup_id_3", 
				"adgroup_name_3");
		ArrayList<AdGroup> listAdGrp = new ArrayList<AdGroup>();
		listAdGrp.add(adgrp1);
		listAdGrp.add(adgrp2);
		listAdGrp.add(adgrp3);
		when(adGrpDAO.saveData(listAdGrp)).thenReturn("Save AdGroup data success");
		String result = adGrpDAO.saveData(listAdGrp);
		assertEquals(result,"Save AdGroup data success");
	}
}
