package com.adver.tran.store.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user_tran_record")
public class UserTranRecord {
	//记录用户的交易记录
	
	@Id
	private String id; //ID
	//@Field("user_id")
	private String userId; //用户ID
	//@Field("type")
	private String type; //用户类型
	//@Field("transum")
	private String transum; //交易金额
	//@Field("balance")
	private String balance; //余额
	//@Field("trandesc")
	private String trandesc; //交易描述
	//@Field("trantime")
	private String trantime; //交易时间
	//@Field("tranid")
	private String tranid; //交易流水
	//@Field("platform")
	private String platform; //交易平台
	//@Field("needid")
	private String needid; //需求ID
	//@Field("cr_time")
	private String crTime; //创建时间
	//@Field("up_time")
	private String upTime; //最后更新时间
	//@Field("sta")
	private String sta; //交易状态
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTransum() {
		return transum;
	}
	public void setTransum(String transum) {
		this.transum = transum;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getTrandesc() {
		return trandesc;
	}
	public void setTrandesc(String trandesc) {
		this.trandesc = trandesc;
	}
	public String getTrantime() {
		return trantime;
	}
	public void setTrantime(String trantime) {
		this.trantime = trantime;
	}
	public String getTranid() {
		return tranid;
	}
	public void setTranid(String tranid) {
		this.tranid = tranid;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getCrTime() {
		return crTime;
	}
	public void setCrTime(String crTime) {
		this.crTime = crTime;
	}
	public String getUpTime() {
		return upTime;
	}
	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
	public String getNeedid() {
		return needid;
	}
	public void setNeedid(String needid) {
		this.needid = needid;
	}
	
}
