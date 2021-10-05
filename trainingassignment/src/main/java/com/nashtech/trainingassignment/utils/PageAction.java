package com.nashtech.trainingassignment.utils;

import org.json.JSONObject;

public class PageAction {
	public static int getTotalPage(String response) {
		JSONObject Jobject = new JSONObject(response);
		JSONObject Jdata = Jobject.getJSONObject("data");
		JSONObject Jtotal = Jdata.getJSONObject("page_info");
		return Jtotal.optInt("total_page");
	}
}
