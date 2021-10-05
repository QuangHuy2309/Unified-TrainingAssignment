package com.nashtech.trainingassignment.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import com.nashtech.trainingassignment.model.Ad;
import com.nashtech.trainingassignment.model.AdGroup;
import com.nashtech.trainingassignment.model.Campaigns;
import com.nashtech.trainingassignment.service.CampaignService;

public class AdDAO {

	private AdDAO() {
	}

	public static AdDAO getInstance() {
		return SingletonAdDAO.INSTANCE;
	}

	private static class SingletonAdDAO {
		private static final AdDAO INSTANCE = new AdDAO();
	}

	public String saveData(ArrayList<Ad> listAd) {
		Connection connect = DatabaseConnector.getConnection();
		String sql = "insert into tk_ad(ad_id, ad_name, ad_text, ad_format, campaign_id, advertiser_id, campaign_name, "
				+ "adgroup_id, adgroup_name, status, opt_status, app_name) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) " + "ON CONFLICT(ad_id) DO UPDATE SET "
				+ "ad_name=?, ad_text=?, ad_format=?, campaign_id=?, advertiser_id=?, campaign_name=?, adgroup_id=?, "
				+ "adgroup_name=?, status=?, opt_status=?, app_name=?";
		AtomicBoolean checkSaveCamp = new AtomicBoolean(true);
		listAd.stream().forEach((ad) -> {
			try {
				PreparedStatement ps = connect.prepareStatement(sql);
				ps.setObject(1, ad.getAd_id());
				ps.setObject(2, ad.getAd_name());
				ps.setObject(3, ad.getAd_text());
				ps.setObject(4, ad.getAd_format());
				ps.setObject(5, ad.getCampaign_id());
				ps.setObject(6, ad.getAdvertiser_id());
				ps.setObject(7, ad.getCampaign_name());
				ps.setObject(8, ad.getAdgroup_id());
				ps.setObject(9, ad.getAdgroup_name());
				ps.setObject(10, ad.getStatus());
				ps.setObject(11, ad.getOpt_status());
				ps.setObject(12, ad.getAppname());
				ps.setObject(13, ad.getAd_name());
				ps.setObject(14, ad.getAd_text());
				ps.setObject(15, ad.getAd_format());
				ps.setObject(16, ad.getCampaign_id());
				ps.setObject(17, ad.getAdvertiser_id());
				ps.setObject(18, ad.getCampaign_name());
				ps.setObject(19, ad.getAdgroup_id());
				ps.setObject(20, ad.getAdgroup_name());
				ps.setObject(21, ad.getStatus());
				ps.setObject(22, ad.getOpt_status());
				ps.setObject(23, ad.getAppname());
				ps.executeUpdate();
				ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
				checkSaveCamp.set(false);
			}
		});
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (checkSaveCamp.get()) ? "Save Ad data success" : "Save Ad data failed";
	}
}
