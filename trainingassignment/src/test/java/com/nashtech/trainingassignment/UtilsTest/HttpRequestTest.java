package com.nashtech.trainingassignment.UtilsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nashtech.trainingassignment.utils.HttpRequest;

public class HttpRequestTest {
	private String token = "8fc7854be9412a39df88a761e22461ab875696fe";
	private String advertiser_id = "6791983391823626245";
	private String PATH = "/open_api/v1.2/ad/get/";
	private HttpRequest httpRequest;

	@BeforeEach
	public void beforeEach() {
		httpRequest = HttpRequest.getInstance();
	}

	@Test
	void getApi_WrongAdvertiserId() throws JSONException {

		String advertiser_id = "1";
		String response = httpRequest.getApi(advertiser_id, token, PATH, "1");
		JSONObject Jobject = new JSONObject(response);
		assertEquals("Advertiser 1 doesn't exist or has been deleted", Jobject.optString("message"));
		assertEquals("40007", Jobject.optString("code"));
	}

	@Test
	void getApi_WrongAccessToken() throws JSONException {
		String token = "1";
		String response = httpRequest.getApi(advertiser_id, token, PATH, "1");
		JSONObject Jobject = new JSONObject(response);
		assertEquals(
				"Access token is invalid, when you call access_token or refresh_token api, old token will become invalid.",
				Jobject.optString("message"));
		assertEquals("40105", Jobject.optString("code"));
	}

	@Test
	void getApi_Success() throws JSONException {
		String response = httpRequest.getApi(advertiser_id, token, PATH, "1");
		JSONObject Jobject = new JSONObject(response);
		assertEquals("OK", Jobject.optString("message"));
		assertEquals("0", Jobject.optString("code"));
	}
}
