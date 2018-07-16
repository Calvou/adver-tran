package com.adver.tran.domain.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class BaseRes {

	@ApiModelProperty(required = true,notes = "用户ID")
	private String userId;
	@ApiModelProperty(required = true,notes = "手机号码")
	private String mobileNo;
	@ApiModelProperty(required = true,notes = "用户名")
	private String userName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
