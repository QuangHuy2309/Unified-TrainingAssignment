package com.nashtech.trainingassignment.service;

import java.net.URI;
import java.net.URISyntaxException;

public abstract  class TikTokComponent {
	protected String advertiser_id;
	protected String token;

	public TikTokComponent(String advertiser_id, String token) {
		this.advertiser_id = advertiser_id;
		this.token = token;
	}
	
    protected String buildUrl(String path) throws URISyntaxException {
        URI uri = new URI("https", "business-api.tiktok.com", path, "", "");
        return uri.toString();
    }

	abstract String getData();
//	
//	
//	abstract void saveData();
}
