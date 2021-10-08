package com.nashtech.trainingassignment.service;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nashtech.trainingassignment.dao.CampaignDAO;
import com.nashtech.trainingassignment.model.Campaign;
import com.nashtech.trainingassignment.utils.HttpRequest;
import com.nashtech.trainingassignment.utils.PageAction;

import org.json.JSONArray;
import org.json.JSONObject;

public class CampaignService extends TikTokComponent {
	private HttpRequest httpRequest;
	private CampaignDAO camDAO;
	private final String PATH = "/open_api/v1.2/campaign/get/";
	private static final ObjectMapper objMapper = new ObjectMapper();

	public CampaignService() {
		super();
	}

	public CampaignService(String advertiser_id, String token) {
		super(advertiser_id, token);
		this.camDAO = CampaignDAO.getInstance();
		this.httpRequest = HttpRequest.getInstance();
	}

	public CampaignService(String advertiser_id, String token, HttpRequest httpRequest) {
		super(advertiser_id, token);
		this.httpRequest = httpRequest;
	}

	public ArrayList<Campaign> dataMapping(String response) {
		JSONObject Jobject = new JSONObject(response);
		JSONObject Jdata = Jobject.getJSONObject("data");
		JSONArray Jarray = Jdata.getJSONArray("list");
		ArrayList<Campaign> listCampaign = new ArrayList<Campaign>();
		for (int i = 0; i < Jarray.length(); i++) {
			JSONObject jObj = Jarray.getJSONObject(i);
			try {
				Campaign campaign = objMapper.readValue(jObj.toString(), Campaign.class);
				listCampaign.add(campaign);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return listCampaign;
	}

	public ArrayList<Campaign> getData() {
		String response = httpRequest.getApi(advertiser_id, token, PATH, "1");
		ArrayList<Campaign> listCampaign = dataMapping(response);
		int totalPage = PageAction.getTotalPage(response);
		if (totalPage > 1) {
			for (int i = 2; i <= totalPage; i++) {
				String nextResponse = httpRequest.getApi(advertiser_id, token, PATH, String.valueOf(i));
				listCampaign.addAll(dataMapping(nextResponse));
			}
		}
		return listCampaign;
	}

	public void saveData() {
		camDAO.saveData(getData());
	}

}
