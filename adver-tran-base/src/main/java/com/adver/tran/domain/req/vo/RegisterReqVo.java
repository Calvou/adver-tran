package com.adver.tran.domain.req.vo;

import com.adver.tran.common.validation.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RegisterReqVo {

	@ApiModelProperty(required = true,notes = "用户呢称")
	@NotEmpty(message = "用户呢称不能为空")
	private String nickname;
	@ApiModelProperty(required = true,notes = "账号")
	private String account;
	@ApiModelProperty(required = true,notes = "密码")
	@NotEmpty(message = "请求时间不能为空")
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
