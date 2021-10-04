package com.nashtech.trainingassignment;

import java.sql.Connection;

import com.nashtech.trainingassignment.service.CampaignService;

public class TrainingassignmentApplication {
	static String token = "8fc7854be9412a39df88a761e22461ab875696fe";
	static String advertiser_id = "6791983391823626245";

	public static void main(String[] args) {
		System.out.println("Hello world");
		CampaignService camp = new CampaignService(advertiser_id, token);
		System.out.println(camp.saveData());
	}

}
