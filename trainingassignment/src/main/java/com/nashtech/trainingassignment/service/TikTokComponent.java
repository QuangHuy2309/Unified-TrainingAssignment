package com.nashtech.trainingassignment.service;


public abstract  class TikTokComponent {
	protected String advertiser_id;
	protected String token;

	public TikTokComponent() {
		super();
	}

	public TikTokComponent(String advertiser_id, String token) {
		this.advertiser_id = advertiser_id;
		this.token = token;
	}	
	
	abstract void saveData();
	
}
