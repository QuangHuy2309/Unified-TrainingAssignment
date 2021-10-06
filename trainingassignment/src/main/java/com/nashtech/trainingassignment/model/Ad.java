package com.nashtech.trainingassignment.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ad {
	private String campaign_id;
	private String advertiser_id;
	private String campaign_name;
	private String ad_id;
	private String ad_name;
	private String ad_text;
	private String ad_format;
	private String adgroup_id;
	private String adgroup_name;
	private String status;
	private String opt_status;
	private String app_name;

	public Ad() {
		super();
	}

	public Ad(String campaign_id, String advertiser_id, String campaign_name, String ad_id, String ad_name,
			String ad_text, String ad_format, String adgroup_id, String adgroup_name, String status, String opt_status,
			String appname) {
		super();
		this.campaign_id = campaign_id;
		this.advertiser_id = advertiser_id;
		this.campaign_name = campaign_name;
		this.ad_id = ad_id;
		this.ad_name = ad_name;
		this.ad_text = ad_text;
		this.ad_format = ad_format;
		this.adgroup_id = adgroup_id;
		this.adgroup_name = adgroup_name;
		this.status = status;
		this.opt_status = opt_status;
		this.app_name = appname;
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

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getAd_name() {
		return ad_name;
	}

	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}

	public String getAd_text() {
		return ad_text;
	}

	public void setAd_text(String ad_text) {
		this.ad_text = ad_text;
	}

	public String getAd_format() {
		return ad_format;
	}

	public void setAd_format(String ad_format) {
		this.ad_format = ad_format;
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

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	@Override
	public String toString() {
		return "Ad [campaign_id=" + campaign_id + ", advertiser_id=" + advertiser_id + ", campaign_name="
				+ campaign_name + ", ad_id=" + ad_id + ", ad_name=" + ad_name + ", ad_text=" + ad_text + ", ad_format="
				+ ad_format + ", adgroup_id=" + adgroup_id + ", adgroup_name=" + adgroup_name + ", status=" + status
				+ ", opt_status=" + opt_status + ", app_name=" + app_name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ad_format, ad_id, ad_name, ad_text, adgroup_id, adgroup_name, advertiser_id, app_name,
				campaign_id, campaign_name, opt_status, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ad other = (Ad) obj;
		return Objects.equals(ad_format, other.ad_format) && Objects.equals(ad_id, other.ad_id)
				&& Objects.equals(ad_name, other.ad_name) && Objects.equals(ad_text, other.ad_text)
				&& Objects.equals(adgroup_id, other.adgroup_id) && Objects.equals(adgroup_name, other.adgroup_name)
				&& Objects.equals(advertiser_id, other.advertiser_id) && Objects.equals(app_name, other.app_name)
				&& Objects.equals(campaign_id, other.campaign_id) && Objects.equals(campaign_name, other.campaign_name)
				&& Objects.equals(opt_status, other.opt_status) && Objects.equals(status, other.status);
	}

}
