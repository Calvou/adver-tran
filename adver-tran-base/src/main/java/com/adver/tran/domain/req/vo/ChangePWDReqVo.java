package com.adver.tran.domain.req.vo;

import com.adver.tran.common.validation.NotEmpty;
import com.adver.tran.domain.base.ApiBaseReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ChangePWDReqVo extends ApiBaseReq{

	@ApiModelProperty(required = true,notes = "账号")
	private String account;
	@ApiModelProperty(required = true,notes = "密码")
	@NotEmpty(message = "请求时间不能为空")
	private String password;
	@ApiModelProperty(required = true,notes = "修改后密码")
	@NotEmpty(message = "请求时间不能为空")
	private String repassword;
	
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
}
