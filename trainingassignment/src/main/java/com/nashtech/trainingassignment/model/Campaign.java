package com.nashtech.trainingassignment.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Campaign {
	private String campaign_id;
	private String advertiser_id;
	private String campaign_name;
	private Float budget;
	private String budget_mode;
	private String status;
	private String opt_status;
	private String objective;
	private String objective_type;
	private String create_time;
	private String modify_time;
	private Integer budget_optimize_switch;
	private Integer bid_type;
	private String optimize_goal;

	public Campaign() {
		super();
	}

	public Campaign(String campaign_id, String advertiser_id, String campaign_name, Float budget, String budget_mode) {
		super();
		this.campaign_id = campaign_id;
		this.advertiser_id = advertiser_id;
		this.campaign_name = campaign_name;
		this.budget = budget;
		this.budget_mode = budget_mode;
	}

	public Campaign(String campaign_id, String advertiser_id, String campaign_name, Float budget, String budget_mode,
			String status, String opt_status, String objective, String objective_type, String create_time,
			String modify_time, Integer budget_optimize_switch, Integer bid_type, String optimize_goal) {
		super();
		this.campaign_id = campaign_id;
		this.advertiser_id = advertiser_id;
		this.campaign_name = campaign_name;
		this.budget = budget;
		this.budget_mode = budget_mode;
		this.status = status;
		this.opt_status = opt_status;
		this.objective = objective;
		this.objective_type = objective_type;
		this.create_time = create_time;
		this.modify_time = modify_time;
		this.budget_optimize_switch = budget_optimize_switch;
		this.bid_type = bid_type;
		this.optimize_goal = optimize_goal;
	}

	public String getCampaign_id() {
		return campaign_id;
	}

	public void setCampaign_id(String campaign_id) {
		this.campaign_id = campaign_id;
	}

	public String getAdvertiser_id() {
		return advertiser_id;
	}

	public void setAdvertiser_id(String advertiser_id) {
		this.advertiser_id = advertiser_id;
	}

	public String getCampaign_name() {
		return campaign_name;
	}

	public void setCampaign_name(String campaign_name) {
		this.campaign_name = campaign_name;
	}

	public Float getBudget() {
		return budget;
	}

	public void setBudget(Float budget) {
		this.budget = budget;
	}

	public String getBudget_mode() {
		return budget_mode;
	}

	public void setBudget_mode(String budget_mode) {
		this.budget_mode = budget_mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOpt_status() {
		return opt_status;
	}

	public void setOpt_status(String opt_status) {
		this.opt_status = opt_status;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getObjective_type() {
		return objective_type;
	}

	public void setObjective_type(String objective_type) {
		this.objective_type = objective_type;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getModify_time() {
		return modify_time;
	}

	public void setModify_time(String modify_time) {
		this.modify_time = modify_time;
	}

	public Integer getBudget_optimize_switch() {
		return budget_optimize_switch;
	}

	public void setBudget_optimize_switch(Integer budget_optimize_switch) {
		this.budget_optimize_switch = budget_optimize_switch;
	}

	public Integer getBid_type() {
		return bid_type;
	}

	public void setBid_type(Integer bid_type) {
		this.bid_type = bid_type;
	}

	public String getOptimize_goal() {
		return optimize_goal;
	}

	public void setOptimize_goal(String optimize_goal) {
		this.optimize_goal = optimize_goal;
	}

	@Override
	public String toString() {
		return "Campaigns [campaign_id=" + campaign_id + ", advertiser_id=" + advertiser_id + ", campaign_name="
				+ campaign_name + ", budget=" + budget + ", budget_mode=" + budget_mode + ", status=" + status
				+ ", opt_status=" + opt_status + ", objective=" + objective + ", objective_type=" + objective_type
				+ ", create_time=" + create_time + ", modify_time=" + modify_time + ", budget_optimize_switch="
				+ budget_optimize_switch + ", bid_type=" + bid_type + ", optimize_goal=" + optimize_goal + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campaign other = (Campaign) obj;
		return Objects.equals(advertiser_id, other.advertiser_id) && Objects.equals(bid_type, other.bid_type)
				&& Objects.equals(budget, other.budget) && Objects.equals(budget_mode, other.budget_mode)
				&& Objects.equals(budget_optimize_switch, other.budget_optimize_switch);
	}

}
