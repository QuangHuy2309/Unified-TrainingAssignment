package com.nashtech.trainingassignment.service;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nashtech.trainingassignment.dao.AdDAO;
import com.nashtech.trainingassignment.model.Ad;
import com.nashtech.trainingassignment.utils.HttpRequest;
import com.nashtech.trainingassignment.utils.PageAction;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdService extends TikTokComponent {
	private HttpRequest httpRequest;
	private AdDAO adDAO;
	private final String PATH = "/open_api/v1.2/ad/get/";
	private static final ObjectMapper objMapper = new ObjectMapper();
	private static final Logger logger = Logger.getLogger(AdService.class);

	public AdService() {
	}

	public AdService(String advertiser_id, String token) {
		super(advertiser_id, token);
		this.adDAO = AdDAO.getInstance();
		this.httpRequest = HttpRequest.getInstance();
	}

	public AdService(String advertiser_id, String token, HttpRequest httpRequest) {
		super(advertiser_id, token);
		this.httpRequest = httpRequest;
	}

	public ArrayList<Ad> dataMapping(String response) {
		JSONObject Jobject = new JSONObject(response);
		JSONObject Jdata = Jobject.getJSONObject("data");
		JSONArray Jarray = Jdata.getJSONArray("list");
		ArrayList<Ad> listAd = new ArrayList<Ad>();
		for (int i = 0; i < Jarray.length(); i++) {
			JSONObject jObj = Jarray.getJSONObject(i);
			try {
				Ad ad = objMapper.readValue(jObj.toString(), Ad.class);
				listAd.add(ad);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return listAd;
	}

	public ArrayList<Ad> getData() {
		String response = httpRequest.getApi(advertiser_id, token, PATH, "1");
		ArrayList<Ad> listAd = dataMapping(response);
		int totalPage = PageAction.getTotalPage(response);
		if (totalPage > 1) {
			for (int i = 2; i <= totalPage; i++) {
				String nextResponse = httpRequest.getApi(advertiser_id, token, PATH, String.valueOf(i));
				listAd.addAll(dataMapping(nextResponse));
			}
		}
		return listAd;
	}

	public void saveData() {
		adDAO.saveData(getData());
	}

}
