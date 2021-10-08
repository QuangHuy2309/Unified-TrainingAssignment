package com.nashtech.trainingassignment.UtilsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.nashtech.trainingassignment.utils.PageAction;

public class PageActionTest {
	@Test
	void getTotalPage_True() {
		String response = "{\"message\": \"OK\", \"code\": 0, \"data\": {\"page_info\": "
				+ "{\"total_number\": 43, \"page\": 1, \"page_size\": 10, \"total_page\": 5}, "
				+ "\"list\": []}, \"request_id\": " + "\"2021100602400801024509900226A00E98\"}";
		assertEquals(PageAction.getTotalPage(response), 5);
	}
}
