package com.nashtech.trainingassignment.DAOTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nashtech.trainingassignment.dao.CampaignDAO;
import com.nashtech.trainingassignment.model.Campaign;

public class CampaignDAOTest {
	@Test
	void getInstance() {
		CampaignDAO camp1 = CampaignDAO.getInstance();
		CampaignDAO camp2 = CampaignDAO.getInstance();
		assertEquals(camp1, camp2);
	}
	@Test
	void saveDataSuccessTest() {
		CampaignDAO campDAO = Mockito.mock(CampaignDAO.class);
		Campaign camp1 = new Campaign("Camp_id_1", "advertiser_id_1", "campaign_name_1", (float) 1.0, "budget_mode_1");
		Campaign camp2 = new Campaign("Camp_id_2", "advertiser_id_2", "campaign_name_2", (float) 2.0, "budget_mode_2");
		Campaign camp3 = new Campaign("Camp_id_3", "advertiser_id_3", "campaign_name_3", (float) 3.0, "budget_mode_3");
		ArrayList<Campaign> listCamp = new ArrayList<>();
		listCamp.add(camp1);
		listCamp.add(camp2);
		listCamp.add(camp3);
		when(campDAO.saveData(listCamp)).thenReturn(true);
		assertTrue(campDAO.saveData(listCamp));
	}
	
	@Test
	void saveDataFailedTest() {
		CampaignDAO campDAO = Mockito.mock(CampaignDAO.class);
		Campaign camp1 = new Campaign("Camp_id_1", "advertiser_id_1", "campaign_name_1", (float) 1.0, "budget_mode_1");
		Campaign camp2 = new Campaign("Camp_id_2", "advertiser_id_2", "campaign_name_2", (float) 2.0, "budget_mode_2");
		Campaign camp3 = new Campaign("Camp_id_3", "advertiser_id_3", "campaign_name_3", (float) 3.0, "budget_mode_3");
		ArrayList<Campaign> listCamp = new ArrayList<>();
		listCamp.add(camp1);
		listCamp.add(camp2);
		listCamp.add(camp3);
		when(campDAO.saveData(listCamp)).thenReturn(false);
		assertFalse(campDAO.saveData(listCamp));
	}
}
