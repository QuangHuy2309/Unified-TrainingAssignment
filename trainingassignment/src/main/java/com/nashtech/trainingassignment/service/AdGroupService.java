package com.nashtech.trainingassignment.service;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nashtech.trainingassignment.dao.AdGroupDAO;
import com.nashtech.trainingassignment.model.AdGroup;
import com.nashtech.trainingassignment.utils.HttpRequest;
import com.nashtech.trainingassignment.utils.PageAction;

import org.json.JSONArray;
import org.json.JSONObject;

public class AdGroupService extends TikTokComponent {
	private HttpRequest httpRequest;
	private AdGroupDAO adGroupDAO;
	private final String PATH = "/open_api/v1.2/adgroup/get/";
	private static final ObjectMapper objMapper = new ObjectMapper();

	public AdGroupService() {
		super();
	}

	public AdGroupService(String advertiser_id, String token) {
		super(advertiser_id, token);
		this.adGroupDAO = AdGroupDAO.getInstance();
		this.httpRequest = HttpRequest.getInstance();
	}

	public AdGroupService(String advertiser_id, String token, HttpRequest httpRequest) {
		super(advertiser_id, token);
		this.httpRequest = httpRequest;
	}

	public ArrayList<AdGroup> dataMapping(String response) {
		JSONObject Jobject = new JSONObject(response);
		JSONObject Jdata = Jobject.getJSONObject("data");
		JSONArray Jarray = Jdata.getJSONArray("list");
		ArrayList<AdGroup> listAdGroup = new ArrayList<AdGroup>();
		objMapper.findAndRegisterModules();
		objMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		for (int i = 0; i < Jarray.length(); i++) {
			JSONObject jObj = Jarray.getJSONObject(i);
			try {
				AdGroup adGroup = objMapper.readValue(jObj.toString(), AdGroup.class);
				listAdGroup.add(adGroup);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return listAdGroup;
	}

	public ArrayList<AdGroup> getData() {
		String response = httpRequest.getApi(advertiser_id, token, PATH, "1");
		ArrayList<AdGroup> listAdGroup = dataMapping(response);
		int totalPage = PageAction.getTotalPage(response);
		if (totalPage > 1) {
			for (int i = 2; i <= totalPage; i++) {
				String nextResponse = httpRequest.getApi(advertiser_id, token, PATH, String.valueOf(i));
				listAdGroup.addAll(dataMapping(nextResponse));
			}
		}
		return listAdGroup;
	}

	public void saveData() {
		adGroupDAO.saveData(getData());
	}

}
