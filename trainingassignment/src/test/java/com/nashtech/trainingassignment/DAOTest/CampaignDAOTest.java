package com.nashtech.trainingassignment.DAOTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.nashtech.trainingassignment.DAO.CampaignDAO;

public class CampaignDAOTest {
	@Test
	void getInstance() {
		CampaignDAO camp1 = CampaignDAO.getInstance();
		CampaignDAO camp2 = CampaignDAO.getInstance();
		assertEquals(camp1, camp2);
	}
}
