package com.nashtech.trainingassignment;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.nashtech.trainingassignment.model.AdGroup;
import com.nashtech.trainingassignment.service.AdGroupService;
import com.nashtech.trainingassignment.service.AdService;
import com.nashtech.trainingassignment.service.CampaignService;

public class TrainingassignmentApplication {
//	static String token = "8fc7854be9412a39df88a761e22461ab875696fe";
//	static String advertiser_id = "6791983391823626245";

	public static void main(String[] args) {
		String token ="";
		String advertiser_id ="";
		Scanner input = new Scanner(System.in);
		System.out.print("Advertiser_id: ");
		advertiser_id = input.nextLine().trim();
		System.out.print("Token: ");
		token = input.nextLine().trim();
		
		if (!advertiser_id.isBlank() && !token.isBlank()) {
//		 CAMPAIGN SERVICES
		CampaignService camp = new CampaignService(advertiser_id, token);
		System.out.println(camp.saveData());
//		 AD GROUP SERVICES
		AdGroupService adGroup = new AdGroupService(advertiser_id, token);
		System.out.println(adGroup.saveData());
//		 AD SERVICES
		AdService ad = new AdService(advertiser_id, token);
		System.out.println(ad.saveData());
	 } else {
         System.out.println("Required two args: Advertiser id and token");
     }
	}
}
