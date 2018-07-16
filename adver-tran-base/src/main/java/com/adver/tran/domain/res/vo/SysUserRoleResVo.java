package com.adver.tran.domain.res.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class SysUserRoleResVo {
	@ApiModelProperty(required = true,notes = "用户ID")
	private String userId;
	@ApiModelProperty(required = true,notes = "角色ID")
	private String roleId;
	@ApiModelProperty(required = true,notes = "用户角色有效性")
	private String valid;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	
}
