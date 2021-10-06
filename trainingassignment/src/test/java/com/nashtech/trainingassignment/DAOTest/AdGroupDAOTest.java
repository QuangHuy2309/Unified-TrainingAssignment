package com.nashtech.trainingassignment.DAOTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.nashtech.trainingassignment.DAO.AdGroupDAO;


public class AdGroupDAOTest {
	@Test
	void getInstance() {
		AdGroupDAO adGrDAO1 = AdGroupDAO.getInstance();
		AdGroupDAO adGrDAO2 = AdGroupDAO.getInstance();
		assertEquals(adGrDAO1, adGrDAO2);
	}
}
