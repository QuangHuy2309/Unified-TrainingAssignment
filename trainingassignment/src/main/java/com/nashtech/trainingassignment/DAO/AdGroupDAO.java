package com.nashtech.trainingassignment.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import com.nashtech.trainingassignment.model.AdGroup;
import com.nashtech.trainingassignment.model.Campaigns;
import com.nashtech.trainingassignment.service.CampaignService;

public class AdGroupDAO {

	private AdGroupDAO() {
	}

	public static AdGroupDAO getInstance() {
		return SingletonAdGroupDAO.INSTANCE;
	}

	private static class SingletonAdGroupDAO {
		private static final AdGroupDAO INSTANCE = new AdGroupDAO();
	}

	public String saveData(ArrayList<AdGroup> listAdGroup) {
		Connection connect = DatabaseConnector.getConnection();
		String sql = "insert into tk_adgroup(adgroup_id, adgroup_name, campaign_id, advertiser_id, campaign_name, status, "
				+ "opt_status, create_time, modify_time, schedule_start_time, schedule_end_time, age, gender, languages, location)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) " + "ON CONFLICT(adgroup_id) DO UPDATE SET "
				+ "adgroup_name=?, campaign_id=?, advertiser_id=?, campaign_name=?, status=?, opt_status=?, create_time=?, "
				+ "modify_time=?, schedule_start_time=?, schedule_end_time=?, age=?, gender=?, languages=?, location=?";
		AtomicBoolean checkSaveAdGroup = new AtomicBoolean(true);
		listAdGroup.stream().forEach((adGroup) -> {
			try {
				PreparedStatement ps = connect.prepareStatement(sql);
				ps.setObject(1, adGroup.getAdgroup_id());
				ps.setObject(2, adGroup.getAdgroup_name());
				ps.setObject(3, adGroup.getCampaign_id());
				ps.setObject(4, adGroup.getAdvertiser_id());
				ps.setObject(5, adGroup.getCampaign_name());
				ps.setObject(6, adGroup.getStatus());
				ps.setObject(7, adGroup.getOpt_status());
				ps.setObject(8, adGroup.getCreate_time());
				ps.setObject(9, adGroup.getModify_time());
				ps.setObject(10, adGroup.getSchedule_start_time());
				ps.setObject(11, adGroup.getSchedule_end_time());
				ps.setObject(12, adGroup.getAge());
				ps.setObject(13, adGroup.getGender());
				ps.setObject(14, adGroup.getLanguages());
				ps.setObject(15, adGroup.getLocation());
				ps.setObject(16, adGroup.getAdgroup_name());
				ps.setObject(17, adGroup.getCampaign_id());
				ps.setObject(18, adGroup.getAdvertiser_id());
				ps.setObject(19, adGroup.getCampaign_name());
				ps.setObject(20, adGroup.getStatus());
				ps.setObject(21, adGroup.getOpt_status());
				ps.setObject(22, adGroup.getCreate_time());
				ps.setObject(23, adGroup.getModify_time());
				ps.setObject(24, adGroup.getSchedule_start_time());
				ps.setObject(25, adGroup.getSchedule_end_time());
				ps.setObject(26, adGroup.getAge());
				ps.setObject(27, adGroup.getGender());
				ps.setObject(28, adGroup.getLanguages());
				ps.setObject(29, adGroup.getLocation());
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				checkSaveAdGroup.set(false);
			}
		});
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (checkSaveAdGroup.get()) ? "Save AdGroup data success" : "Save AdGroup data failed";
	}
}
