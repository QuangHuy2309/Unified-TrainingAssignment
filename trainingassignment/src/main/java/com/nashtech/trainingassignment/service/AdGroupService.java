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
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nashtech.trainingassignment.dao.AdGroupDAO;
import com.nashtech.trainingassignment.dao.DatabaseConnector;
import com.nashtech.trainingassignment.model.AdGroup;
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

public class AdGroupService extends TikTokComponent {
	private AdGroupDAO adGroupDAO;
	private final String PATH = "/open_api/v1.2/adgroup/get/";
	private static final ObjectMapper objMapper = new ObjectMapper();

	public AdGroupService() {
		super();
	}

	public AdGroupService(String advertiser_id, String token) {
		super(advertiser_id, token);
		this.adGroupDAO = AdGroupDAO.getInstance();
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
		String response = HttpRequest.getApi(advertiser_id, token, PATH, "1");
		ArrayList<AdGroup> listAdGroup = dataMapping(response);
		int totalPage = PageAction.getTotalPage(response);
		if (totalPage > 1) {
			for (int i = 2; i <= totalPage; i++) {
				String nextResponse = HttpRequest.getApi(advertiser_id, token, PATH, String.valueOf(i));
				listAdGroup.addAll(dataMapping(nextResponse));
			}
		}
		return listAdGroup;
	}

	public String saveData() {
		return adGroupDAO.saveData(getData()) ? "Save AdGroup data success" : "Save AdGroup data failed";
	}

}
