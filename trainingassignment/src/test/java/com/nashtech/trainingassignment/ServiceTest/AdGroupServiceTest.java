package com.nashtech.trainingassignment.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.nashtech.trainingassignment.model.Ad;
import com.nashtech.trainingassignment.model.AdGroup;
import com.nashtech.trainingassignment.service.AdGroupService;
import com.nashtech.trainingassignment.service.AdService;
import com.nashtech.trainingassignment.utils.HttpRequest;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AdGroupServiceTest {
	String token = "8fc7854be9412a39df88a761e22461ab875696fe";
	String advertiser_id = "6791983391823626245";
	String PATH = "/open_api/v1.2/adgroup/get/";

	@Mock
	HttpRequest httpRequestMock;
	
//	@InjectMocks
//	AdGroupService adGroupServiceMock;

	@BeforeEach
	public void beforeEach() {
//		httpRequestMock= Mockito.mock(HttpRequest.class);
//		adGroupServiceMock = new AdGroupService(httpRequestMock);
//		adGroupServiceMock = Mockito.mock(AdGroupService.class);
	}

	@Test
	void dataMappingTest_Success() {
		AdGroupService adGroupService = new AdGroupService();
		AdGroup adgrp1 = new AdGroup("Camp_id_1", "advertiser_id_1", "campaign_name_1", "adgroup_id_1",
				"adgroup_name_1");
		AdGroup adgrp2 = new AdGroup("Camp_id_2", "advertiser_id_2", "campaign_name_2", "adgroup_id_2",
				"adgroup_name_2");
		AdGroup adgrp3 = new AdGroup("Camp_id_3", "advertiser_id_3", "campaign_name_3", "adgroup_id_3",
				"adgroup_name_3");
		ArrayList<AdGroup> listAdGrp = new ArrayList<AdGroup>();
		listAdGrp.add(adgrp1);
		listAdGrp.add(adgrp2);
		listAdGrp.add(adgrp3);
		String response = "{\r\n" + "    \"message\": \"OK\",\r\n" + "    \"code\": 0,\r\n" + "    \"data\": {\r\n"
				+ "        \"page_info\": {\r\n" + "            \"total_number\": 43,\r\n"
				+ "            \"page\": 1,\r\n" + "            \"page_size\": 10,\r\n"
				+ "            \"total_page\": 5\r\n" + "        },\r\n" + "        \"list\": [\r\n"
				+ "            {\r\n" + "\"campaign_id\": \"Camp_id_1\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_1\",\r\n" + "\"campaign_name\": \"campaign_name_1\", \r\n"
				+ "\"adgroup_id\": \"adgroup_id_1\",\r\n" + "\"adgroup_name\": \"adgroup_name_1\"},\r\n" + "{\r\n"
				+ "\"campaign_id\": \"Camp_id_2\",  \r\n" + "\"advertiser_id\": \"advertiser_id_2\",\r\n"
				+ "\"campaign_name\": \"campaign_name_2\", \r\n" + "\"adgroup_id\": \"adgroup_id_2\",\r\n"
				+ "\"adgroup_name\": \"adgroup_name_2\"},\r\n" + "{\r\n" + "\"campaign_id\": \"Camp_id_3\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_3\",\r\n" + "\"campaign_name\": \"campaign_name_3\",\r\n"
				+ "\"adgroup_id\": \"adgroup_id_3\",\r\n" + "\"adgroup_name\": \"adgroup_name_3\"\r\n" + "}\r\n"
				+ "        ]\r\n" + "    },\r\n" + "    \"request_id\": \"202110060408360102452441991CAC1149\"\r\n"
				+ "}";

		ArrayList<AdGroup> adGrpList_test = adGroupService.dataMapping(response);
		assertTrue(listAdGrp.get(0).equals(adGrpList_test.get(0)));
		assertTrue(listAdGrp.equals(adGrpList_test));
	}

	@Test
	void getDataTest_Success() {
		String response = "{\r\n" + "    \"message\": \"OK\",\r\n" + "    \"code\": 0,\r\n" + "    \"data\": {\r\n"
				+ "        \"page_info\": {\r\n" + "            \"total_number\": 43,\r\n"
				+ "            \"page\": 1,\r\n" + "            \"page_size\": 10,\r\n"
				+ "            \"total_page\": 2\r\n" + "        },\r\n" + "        \"list\": [\r\n"
				+ "            {\r\n" + "\"campaign_id\": \"Camp_id_1\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_1\",\r\n" + "\"campaign_name\": \"campaign_name_1\", \r\n"
				+ "\"adgroup_id\": \"adgroup_id_1\",\r\n" + "\"adgroup_name\": \"adgroup_name_1\"},\r\n" + "{\r\n"
				+ "\"campaign_id\": \"Camp_id_2\",  \r\n" + "\"advertiser_id\": \"advertiser_id_2\",\r\n"
				+ "\"campaign_name\": \"campaign_name_2\", \r\n" + "\"adgroup_id\": \"adgroup_id_2\",\r\n"
				+ "\"adgroup_name\": \"adgroup_name_2\"},\r\n" + "{\r\n" + "\"campaign_id\": \"Camp_id_3\",  \r\n"
				+ "\"advertiser_id\": \"advertiser_id_3\",\r\n" + "\"campaign_name\": \"campaign_name_3\",\r\n"
				+ "\"adgroup_id\": \"adgroup_id_3\",\r\n" + "\"adgroup_name\": \"adgroup_name_3\"\r\n" + "}\r\n"
				+ "        ]\r\n" + "    },\r\n" + "    \"request_id\": \"202110060408360102452441991CAC1149\"\r\n"
				+ "}";
		assertNotNull(httpRequestMock);
		AdGroupService adGroupService = new AdGroupService(advertiser_id, token,httpRequestMock);
		when(httpRequestMock.getApi(advertiser_id, token, PATH, "1"))
				.thenReturn(response);
		when(httpRequestMock.getApi(advertiser_id, token, PATH, "2"))
		.thenReturn(response);
		ArrayList<AdGroup> adGrpList_test = adGroupService.getData();
		assertEquals(adGrpList_test.size(), 6);
	}
}
