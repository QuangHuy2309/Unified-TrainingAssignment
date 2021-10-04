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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nashtech.trainingassignment.DatabaseConnector;
import com.nashtech.trainingassignment.model.Campaigns;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;

public class CampaignService extends TikTokComponent {

	private final String PATH = "/open_api/v1.2/campaign/get";
	private static final ModelMapper mapper = new ModelMapper();
	private static final ObjectMapper objMapper = new ObjectMapper();

	public CampaignService(String advertiser_id, String token) {
		super(advertiser_id, token);
	}

	@Override
	public String getData() {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		URIBuilder ub;
		URL url = null;
		try {
			ub = new URIBuilder(buildUrl(PATH));
			ub.addParameter("advertiser_id", advertiser_id);

			url = ub.build().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		Request request = new Request.Builder().url(url).method("GET", null).addHeader("Access-Token", token).build();
		Response response;
		try {
			response = client.newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Campaigns> dataMapping(String response) {
		JSONObject Jobject = new JSONObject(response);
		JSONObject Jdata = Jobject.getJSONObject("data");
		JSONArray Jarray = Jdata.getJSONArray("list");
		ArrayList<Campaigns> listCampaign = new ArrayList<Campaigns>();
		for (int i = 0; i < Jarray.length(); i++) {
			JSONObject jObj = Jarray.getJSONObject(i);
			try {
				Campaigns campaign = objMapper.readValue(jObj.toString(), Campaigns.class);
				listCampaign.add(campaign);
//				System.out.println(campaign.toString());
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return listCampaign;

	}

	public String saveData() {
		ArrayList<Campaigns> listCampaign = dataMapping(getData());
		Connection connect = DatabaseConnector.getConnection();
		String sql = "insert into tk_campaign(campaign_id, advertiser_id, campaign_name, budget, budget_mode, status, "
				+ "opt_status, objective, objective_type, create_time, modify_time, budget_optimize_switch, bid_type, optimize_goal)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) "
				+ "ON CONFLICT(campaign_id) DO UPDATE SET "
				+ "advertiser_id=?, campaign_name=?, budget=?, budget_mode=?, status=?, opt_status=?, objective=?, "
				+ "objective_type=?, create_time=?, modify_time=?, budget_optimize_switch=?, bid_type=?, optimize_goal=?";

		listCampaign.stream().forEach((camp) -> {
			try {
				PreparedStatement ps = connect.prepareStatement(sql);
				ps.setObject(1, camp.getCampaign_id());
				ps.setObject(2, camp.getAdvertiser_id());
				ps.setObject(3, camp.getCampaign_name());
				ps.setObject(4, camp.getBudget());
				ps.setObject(5, camp.getBudget_mode());
				ps.setObject(6, camp.getStatus());
				ps.setObject(7, camp.getOpt_status());
				ps.setObject(8, camp.getObjective());
				ps.setObject(9, camp.getObjective_type());
				ps.setObject(10, camp.getCreate_time());
				ps.setObject(11, camp.getModify_time());
				ps.setObject(12, camp.getBudget_optimize_switch());
				ps.setObject(13, camp.getBid_type());
				ps.setObject(14, camp.getOptimize_goal());
				ps.setObject(15, camp.getAdvertiser_id());
				ps.setObject(16, camp.getCampaign_name());
				ps.setObject(17, camp.getBudget());
				ps.setObject(18, camp.getBudget_mode());
				ps.setObject(19, camp.getStatus());
				ps.setObject(20, camp.getOpt_status());
				ps.setObject(21, camp.getObjective());
				ps.setObject(22, camp.getObjective_type());
				ps.setObject(23, camp.getCreate_time());
				ps.setObject(24, camp.getModify_time());
				ps.setObject(25, camp.getBudget_optimize_switch());
				ps.setObject(26, camp.getBid_type());
				ps.setObject(27, camp.getOptimize_goal());
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return "Save data success";
	}

}
