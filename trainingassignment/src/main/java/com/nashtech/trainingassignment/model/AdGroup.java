package com.nashtech.trainingassignment.model;

import java.time.LocalDateTime;

public class AdGroup {
	private String campaign_id;
	private String advertiser_id;
	private String campaign_name;
	private String adgroup_id;
	private String adgroup_name;
	private String status;
	private String opt_status;
	private String create_time;
	private String modify_time;
	private LocalDateTime schedule_start_time;
	private LocalDateTime schedule_end_time;
	private String age;
	private String gender;
	private String languages;
	private String location;

	public AdGroup() {
		super();
	}

	public AdGroup(String campaign_id, String advertiser_id, String campaign_name, String adgroup_id,
			String adgroup_name, String status, String opt_status, String create_time, String modify_time,
			LocalDateTime schedule_start_time, LocalDateTime schedule_end_time, String age, String gender,
			String languages, String location) {
		super();
		this.campaign_id = campaign_id;
		this.advertiser_id = advertiser_id;
		this.campaign_name = campaign_name;
		this.adgroup_id = adgroup_id;
		this.adgroup_name = adgroup_name;
		this.status = status;
		this.opt_status = opt_status;
		this.create_time = create_time;
		this.modify_time = modify_time;
		this.schedule_start_time = schedule_start_time;
		this.schedule_end_time = schedule_end_time;
		this.age = age;
		this.gender = gender;
		this.languages = languages;
		this.location = location;
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

	public String getAdgroup_id() {
		return adgroup_id;
	}

	public void setAdgroup_id(String adgroup_id) {
		this.adgroup_id = adgroup_id;
	}

	public String getAdgroup_name() {
		return adgroup_name;
	}

	public void setAdgroup_name(String adgroup_name) {
		this.adgroup_name = adgroup_name;
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

	public LocalDateTime getSchedule_start_time() {
		return schedule_start_time;
	}

	public void setSchedule_start_time(LocalDateTime schedule_start_time) {
		this.schedule_start_time = schedule_start_time;
	}

	public LocalDateTime getSchedule_end_time() {
		return schedule_end_time;
	}

	public void setSchedule_end_time(LocalDateTime schedule_end_time) {
		this.schedule_end_time = schedule_end_time;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "AdGroup [campaign_id=" + campaign_id + ", advertiser_id=" + advertiser_id + ", campaign_name="
				+ campaign_name + ", adgroup_id=" + adgroup_id + ", adgroup_name=" + adgroup_name + ", status=" + status
				+ ", opt_status=" + opt_status + ", create_time=" + create_time + ", modify_time=" + modify_time
				+ ", schedule_start_time=" + schedule_start_time + ", schedule_end_time=" + schedule_end_time + ", age="
				+ age + ", gender=" + gender + ", languages=" + languages + ", location=" + location + "]";
	}

}
