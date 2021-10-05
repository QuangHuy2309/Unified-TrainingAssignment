package com.nashtech.trainingassignment.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
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
import com.nashtech.trainingassignment.DAO.DatabaseConnector;
import com.nashtech.trainingassignment.model.Campaigns;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;

public class HttpRequest {

	private static String buildUrl(String path) throws URISyntaxException {
		URI uri = new URI("https", "business-api.tiktok.com", path, "", "");
		return uri.toString();
	}

	public static String getApi(String advertiser_id, String token, String PATH, String page) {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		URIBuilder ub;
		URL url = null;
		try {
			ub = new URIBuilder(buildUrl(PATH));
			ub.addParameter("advertiser_id", advertiser_id);
			ub.addParameter("page", page);
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
}
