package com.nashtech.trainingassignment.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nashtech.trainingassignment.model.Ad;
import com.nashtech.trainingassignment.service.AdService;
import com.nashtech.trainingassignment.utils.HttpRequest;

@ExtendWith(MockitoExtension.class)
public class AdServiceTest {
	String token = "8fc7854be9412a39df88a761e22461ab875696fe";
	String advertiser_id = "6791983391823626245";
	String PATH = "/open_api/v1.2/ad/get/";

	@Mock
	HttpRequest httpRequestMock;

	@Test
	void dataMappingTest_Success() {
		AdService adService = new AdService();
		Ad ad1 = new Ad("Camp_id_1", "advertiser_id_1", "campaign_name_1", "ad_id_1", "ad_name_1", "ad_text_1",
				"ad_format_1", "adgroup_id_1", "adgroup_name_1", "status_1", "otp_status_1", "appname_1");
		Ad ad2 = new Ad("Camp_id_2", "advertiser_id_2", "campaign_name_2", "ad_id_2", "ad_name_2", "ad_text_2",
				"ad_format_2", "adgroup_id_2", "adgroup_name_2", "status_2", "otp_status_2", "appname_2");
		Ad ad3 = new Ad("Camp_id_3", "advertiser_id_3", "campaign_name_3", "ad_id_3", "ad_name_3", "ad_text_3",
				"ad_format_3", "adgroup_id_3", "adgroup_name_3", "status_3", "otp_status_3", "appname_3");
		ArrayList<Ad> listAd = new ArrayList<Ad>();
		listAd.add(ad1);
		listAd.add(ad2);
		listAd.add(ad3);
		String response = "{\r\n" + "    \"message\": \"OK\",\r\n" + "    \"code\": 0,\r\n" + "    \"data\": {\r\n"
				+ "        \"page_info\": {\r\n" + "            \"total_number\": 43,\r\n"
				+ "            \"page\": 1,\r\n" + "            \"page_size\": 10,\r\n"
				+ "            \"total_page\": 5\r\n" + "        },\r\n" + "        \"list\": [\r\n"
				+ "            {\r\n" + "\"campaign_id\": \"Camp_id_1\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_1\",\r\n" + "\"campaign_name\": \"campaign_name_1\",\r\n"
				+ "\"ad_id\": \"ad_id_1\",\r\n" + "\"ad_name\": \"ad_name_1\", \r\n" + "\"ad_text\": \"ad_text_1\",\r\n"
				+ "\"ad_format\": \"ad_format_1\", \r\n" + "\"adgroup_id\": \"adgroup_id_1\",\r\n"
				+ "\"adgroup_name\": \"adgroup_name_1\", \r\n" + "\"status\": \"status_1\", \r\n"
				+ "\"opt_status\": \"otp_status_1\", \r\n" + "\"app_name\": \"appname_1\"},\r\n" + "{\r\n"
				+ "\"campaign_id\": \"Camp_id_2\",  \r\n" + "\"advertiser_id\": \"advertiser_id_2\",\r\n"
				+ "\"campaign_name\": \"campaign_name_2\",\r\n" + "\"ad_id\": \"ad_id_2\",\r\n"
				+ "\"ad_name\": \"ad_name_2\", \r\n" + "\"ad_text\": \"ad_text_2\",\r\n"
				+ "\"ad_format\": \"ad_format_2\", \r\n" + "\"adgroup_id\": \"adgroup_id_2\",\r\n"
				+ "\"adgroup_name\": \"adgroup_name_2\", \r\n" + "\"status\": \"status_2\", \r\n"
				+ "\"opt_status\": \"otp_status_2\", \r\n" + "\"app_name\": \"appname_2\"},\r\n" + "{\r\n"
				+ "\"campaign_id\": \"Camp_id_3\",  \r\n" + "\"advertiser_id\": \"advertiser_id_3\",\r\n"
				+ "\"campaign_name\": \"campaign_name_3\",\r\n" + "\"ad_id\": \"ad_id_3\",\r\n"
				+ "\"ad_name\": \"ad_name_3\", \r\n" + "\"ad_text\": \"ad_text_3\",\r\n"
				+ "\"ad_format\": \"ad_format_3\", \r\n" + "\"adgroup_id\": \"adgroup_id_3\",\r\n"
				+ "\"adgroup_name\": \"adgroup_name_3\", \r\n" + "\"status\": \"status_3\", \r\n"
				+ "\"opt_status\": \"otp_status_3\", \r\n" + "\"app_name\": \"appname_3\"}\r\n" + "        ]\r\n"
				+ "    },\r\n" + "    \"request_id\": \"202110060408360102452441991CAC1149\"\r\n" + "}";

		ArrayList<Ad> adList_test = adService.dataMapping(response);
		assertTrue(listAd.get(0).equals(adList_test.get(0)));
		assertTrue(listAd.equals(adList_test));
	}

	@Test
	void getDataTest_Success() {
		String response = "{\r\n" + "    \"message\": \"OK\",\r\n" + "    \"code\": 0,\r\n" + "    \"data\": {\r\n"
				+ "        \"page_info\": {\r\n" + "            \"total_number\": 43,\r\n"
				+ "            \"page\": 1,\r\n" + "            \"page_size\": 10,\r\n"
				+ "            \"total_page\": 2\r\n" + "        },\r\n" + "        \"list\": [\r\n"
				+ "            {\r\n" + "\"campaign_id\": \"Camp_id_1\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_1\",\r\n" + "\"campaign_name\": \"campaign_name_1\",\r\n"
				+ "\"ad_id\": \"ad_id_1\",\r\n" + "\"ad_name\": \"ad_name_1\", \r\n" + "\"ad_text\": \"ad_text_1\",\r\n"
				+ "\"ad_format\": \"ad_format_1\", \r\n" + "\"adgroup_id\": \"adgroup_id_1\",\r\n"
				+ "\"adgroup_name\": \"adgroup_name_1\", \r\n" + "\"status\": \"status_1\", \r\n"
				+ "\"opt_status\": \"otp_status_1\", \r\n" + "\"app_name\": \"appname_1\"},\r\n" + "{\r\n"
				+ "\"campaign_id\": \"Camp_id_2\",  \r\n" + "\"advertiser_id\": \"advertiser_id_2\",\r\n"
				+ "\"campaign_name\": \"campaign_name_2\",\r\n" + "\"ad_id\": \"ad_id_2\",\r\n"
				+ "\"ad_name\": \"ad_name_2\", \r\n" + "\"ad_text\": \"ad_text_2\",\r\n"
				+ "\"ad_format\": \"ad_format_2\", \r\n" + "\"adgroup_id\": \"adgroup_id_2\",\r\n"
				+ "\"adgroup_name\": \"adgroup_name_2\", \r\n" + "\"status\": \"status_2\", \r\n"
				+ "\"opt_status\": \"otp_status_2\", \r\n" + "\"app_name\": \"appname_2\"},\r\n" + "{\r\n"
				+ "\"campaign_id\": \"Camp_id_3\",  \r\n" + "\"advertiser_id\": \"advertiser_id_3\",\r\n"
				+ "\"campaign_name\": \"campaign_name_3\",\r\n" + "\"ad_id\": \"ad_id_3\",\r\n"
				+ "\"ad_name\": \"ad_name_3\", \r\n" + "\"ad_text\": \"ad_text_3\",\r\n"
				+ "\"ad_format\": \"ad_format_3\", \r\n" + "\"adgroup_id\": \"adgroup_id_3\",\r\n"
				+ "\"adgroup_name\": \"adgroup_name_3\", \r\n" + "\"status\": \"status_3\", \r\n"
				+ "\"opt_status\": \"otp_status_3\", \r\n" + "\"app_name\": \"appname_3\"}\r\n" + "        ]\r\n"
				+ "    },\r\n" + "    \"request_id\": \"202110060408360102452441991CAC1149\"\r\n" + "}";
		assertNotNull(httpRequestMock);
		AdService adService = new AdService(advertiser_id, token, httpRequestMock);
		when(httpRequestMock.getApi(advertiser_id, token, PATH, "1")).thenReturn(response);
		when(httpRequestMock.getApi(advertiser_id, token, PATH, "2")).thenReturn(response);
		ArrayList<Ad> adList_test = adService.getData();
		assertEquals(adList_test.size(), 6);
	}
}
