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

import com.nashtech.trainingassignment.model.Campaign;
import com.nashtech.trainingassignment.service.CampaignService;
import com.nashtech.trainingassignment.utils.HttpRequest;

@ExtendWith(MockitoExtension.class)
public class CampaignServiceTest {
	String token = "8fc7854be9412a39df88a761e22461ab875696fe";
	String advertiser_id = "6791983391823626245";
	String PATH = "/open_api/v1.2/campaign/get/";

	@Mock
	HttpRequest httpRequestMock;
	
	@Test
	void dataMappingTest_Success() {
		CampaignService campService = new CampaignService();
		Campaign camp1 = new Campaign("Camp_id_1", "advertiser_id_1", "campaign_name_1", (float) 1.0, "budget_mode_1");
		Campaign camp2 = new Campaign("Camp_id_2", "advertiser_id_2", "campaign_name_2", (float) 2.0, "budget_mode_2");
		Campaign camp3 = new Campaign("Camp_id_3", "advertiser_id_3", "campaign_name_3", (float) 3.0, "budget_mode_3");
		ArrayList<Campaign> listCamp = new ArrayList<>();
		listCamp.add(camp1);
		listCamp.add(camp2);
		listCamp.add(camp3);
		String response = "{\r\n"
				+ "    \"message\": \"OK\",\r\n"
				+ "    \"code\": 0,\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"page_info\": {\r\n"
				+ "            \"total_number\": 43,\r\n"
				+ "            \"page\": 1,\r\n"
				+ "            \"page_size\": 10,\r\n"
				+ "            \"total_page\": 5\r\n"
				+ "        },\r\n"
				+ "        \"list\": [\r\n"
				+ "            {\r\n"
				+ "\"campaign_id\": \"Camp_id_1\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_1\",\r\n"
				+ "\"campaign_name\": \"campaign_name_1\", \r\n"
				+ "\"budget\": 1.0,\r\n"
				+ "\"budget_mode\": \"budget_mode_1\"},\r\n"
				+ "{\r\n"
				+ "\"campaign_id\": \"Camp_id_2\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_2\",\r\n"
				+ "\"campaign_name\": \"campaign_name_2\", \r\n"
				+ "\"budget\": 2.0,\r\n"
				+ "\"budget_mode\": \"budget_mode_2\"},\r\n"
				+ "{\r\n"
				+ "\"campaign_id\": \"Camp_id_3\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_3\",\r\n"
				+ "\"campaign_name\": \"campaign_name_3\", \r\n"
				+ "\"budget\": 3.0,\r\n"
				+ "\"budget_mode\": \"budget_mode_3\"\r\n"
				+ "}\r\n"
				+ "        ]\r\n"
				+ "    },\r\n"
				+ "    \"request_id\": \"202110060408360102452441991CAC1149\"\r\n"
				+ "}";
		ArrayList<Campaign> listCamp_test = campService.dataMapping(response);
		assertTrue(listCamp.get(0).equals(listCamp_test.get(0)));
		assertTrue(listCamp.equals(listCamp_test));
	}
	@Test
	void getDataTest_Success() {
		String response = "{\r\n"
				+ "    \"message\": \"OK\",\r\n"
				+ "    \"code\": 0,\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"page_info\": {\r\n"
				+ "            \"total_number\": 43,\r\n"
				+ "            \"page\": 1,\r\n"
				+ "            \"page_size\": 10,\r\n"
				+ "            \"total_page\": 2\r\n"
				+ "        },\r\n"
				+ "        \"list\": [\r\n"
				+ "            {\r\n"
				+ "\"campaign_id\": \"Camp_id_1\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_1\",\r\n"
				+ "\"campaign_name\": \"campaign_name_1\", \r\n"
				+ "\"budget\": 1.0,\r\n"
				+ "\"budget_mode\": \"budget_mode_1\"},\r\n"
				+ "{\r\n"
				+ "\"campaign_id\": \"Camp_id_2\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_2\",\r\n"
				+ "\"campaign_name\": \"campaign_name_2\", \r\n"
				+ "\"budget\": 2.0,\r\n"
				+ "\"budget_mode\": \"budget_mode_2\"},\r\n"
				+ "{\r\n"
				+ "\"campaign_id\": \"Camp_id_3\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_3\",\r\n"
				+ "\"campaign_name\": \"campaign_name_3\", \r\n"
				+ "\"budget\": 3.0,\r\n"
				+ "\"budget_mode\": \"budget_mode_3\"\r\n"
				+ "}\r\n"
				+ "        ]\r\n"
				+ "    },\r\n"
				+ "    \"request_id\": \"202110060408360102452441991CAC1149\"\r\n"
				+ "}";
		assertNotNull(httpRequestMock);
		CampaignService campService = new CampaignService(advertiser_id, token, httpRequestMock);
		when(httpRequestMock.getApi(advertiser_id, token, PATH, "1")).thenReturn(response);
		when(httpRequestMock.getApi(advertiser_id, token, PATH, "2")).thenReturn(response);
		ArrayList<Campaign> listCamp_test = campService.getData();
		assertEquals(listCamp_test.size(), 6);
	}
}
