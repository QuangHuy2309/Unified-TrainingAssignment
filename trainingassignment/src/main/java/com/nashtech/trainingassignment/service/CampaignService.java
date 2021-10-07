package com.nashtech.trainingassignment.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nashtech.trainingassignment.dao.CampaignDAO;
import com.nashtech.trainingassignment.dao.DatabaseConnector;
import com.nashtech.trainingassignment.model.Campaign;
import com.nashtech.trainingassignment.utils.HttpRequest;
import com.nashtech.trainingassignment.utils.PageAction;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;

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

	public String saveData() {
		return camDAO.saveData(getData())  ? "Save Campaign data success" : "Save Campaign data failed";
	}

}
