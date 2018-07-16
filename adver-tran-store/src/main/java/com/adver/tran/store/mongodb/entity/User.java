package com.adver.tran.store.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class User {
	//用户主信息表
	//记录用户全部信息 及 用户类型

	@Id
	private String id; //ID
	//@Field("nick_name")
	private String nickName; //呢称
	//@Field("type")
	private String type; //用户类型
	//@Field("account")
	private String account; //用户类型
	//@Field("mobile")
	private String mobile; //手机号码
	//@Field("passwd")
	private String passwd; //密码
	//@Field("email")
	private String email; //邮件
	//@Field("wxnumber")
	private String wxnumber; //微信号
	//@Field("balance")
	private String balance; //余额
	//@Field("cr_time")
	private String crTime; //创建时间
	//@Field("up_time")
	private String upTime; //最后更新时间
	private String sta; //用户状态
	private String leval; //用户等级
	
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
	public String getLeval() {
		return leval;
	}
	public void setLeval(String leval) {
		this.leval = leval;
	}
	public String getWxnumber() {
		return wxnumber;
	}
	public void setWxnumber(String wxnumber) {
		this.wxnumber = wxnumber;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	

}
