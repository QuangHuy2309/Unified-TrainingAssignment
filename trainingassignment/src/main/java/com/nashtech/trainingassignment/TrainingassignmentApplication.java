package com.nashtech.trainingassignment;

import java.sql.Connection;
import java.util.ArrayList;

import com.nashtech.trainingassignment.model.AdGroup;
import com.nashtech.trainingassignment.service.AdGroupService;
import com.nashtech.trainingassignment.service.AdService;
import com.nashtech.trainingassignment.service.CampaignService;

public class TrainingassignmentApplication {
	static String token = "8fc7854be9412a39df88a761e22461ab875696fe";
	static String advertiser_id = "6791983391823626245";

	public static void main(String[] args) {
//		 CAMPAIGN SERVICES
		CampaignService camp = new CampaignService(advertiser_id, token);
		System.out.println(camp.saveData());
//		 AD GROUP SERVICES
		AdGroupService adGroup = new AdGroupService(advertiser_id, token);
		System.out.println(adGroup.saveData());
//		 AD SERVICES
		AdService ad = new AdService(advertiser_id, token);
		System.out.println(ad.saveData());
		
	}

}
