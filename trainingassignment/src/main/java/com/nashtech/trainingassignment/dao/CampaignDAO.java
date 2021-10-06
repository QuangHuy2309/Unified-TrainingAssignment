package com.nashtech.trainingassignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;

import com.nashtech.trainingassignment.model.Campaign;

public class CampaignDAO {
	private static final Logger logger = Logger.getLogger(AdDAO.class);

	private CampaignDAO() {
	}

	public static CampaignDAO getInstance() {
		return SingletonCampaignDAO.INSTANCE;
	}

	private static class SingletonCampaignDAO {
		private static final CampaignDAO INSTANCE = new CampaignDAO();
	}

	public boolean saveData(ArrayList<Campaign> listCampaign) {
		Connection connect = DatabaseConnector.getConnection();
		String sql = "insert into tk_campaign(campaign_id, advertiser_id, campaign_name, budget, budget_mode, status, "
				+ "opt_status, objective, objective_type, create_time, modify_time, budget_optimize_switch, bid_type, optimize_goal)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) " + "ON CONFLICT(campaign_id) DO UPDATE SET "
				+ "advertiser_id=?, campaign_name=?, budget=?, budget_mode=?, status=?, opt_status=?, objective=?, "
				+ "objective_type=?, create_time=?, modify_time=?, budget_optimize_switch=?, bid_type=?, optimize_goal=?";
		AtomicBoolean checkSaveCamp = new AtomicBoolean(true);
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
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				checkSaveCamp.set(false);
			}
		});
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (checkSaveCamp.get())
			logger.info("Save Campaign data success");
		else
			logger.info("Save Campaign data failed");
		return checkSaveCamp.get();
	}
}
