package com.adver.tran.domain.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiBaseReq {

	@ApiModelProperty(required = true,notes = "用户ID")
	private String userId          ;	
	@ApiModelProperty(required = true,notes = "用户名")
	private String name        ;	
	@ApiModelProperty(required = true,notes = "用户类型")
	private String type;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
