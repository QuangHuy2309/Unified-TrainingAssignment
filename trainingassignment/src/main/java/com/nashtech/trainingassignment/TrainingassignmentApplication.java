package com.nashtech.trainingassignment;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.nashtech.trainingassignment.service.AdGroupService;
import com.nashtech.trainingassignment.service.AdService;
import com.nashtech.trainingassignment.service.CampaignService;

public class TrainingassignmentApplication {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(TrainingassignmentApplication.class);
		String token = "";
		String advertiser_id = "";
		Scanner input = new Scanner(System.in);
		System.out.print("Advertiser_id: ");
		advertiser_id = input.nextLine().trim();
		System.out.print("Token: ");
		token = input.nextLine().trim();
		input.close();
		if (!advertiser_id.isBlank() && !token.isBlank()) {
			CampaignService camp = new CampaignService(advertiser_id, token);
			camp.saveData();
			AdGroupService adGroup = new AdGroupService(advertiser_id, token);
			adGroup.saveData();
			AdService ad = new AdService(advertiser_id, token);
			ad.saveData();
		} else {
			logger.error("Required two args: Advertiser id and token");
		}
	}
}
