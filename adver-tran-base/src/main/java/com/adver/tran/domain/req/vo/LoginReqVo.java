package com.adver.tran.domain.req.vo;

import com.adver.tran.common.validation.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class LoginReqVo {

	@ApiModelProperty(required = true,notes = "账号")
	@NotEmpty(message = "账号未上送")
	private String account;
	@ApiModelProperty(required = true,notes = "密码")
	@NotEmpty(message = "密码未上送")
	private String password;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
