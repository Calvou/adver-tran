package com.adver.tran.domain.res;

import com.adver.tran.domain.res.vo.SysUserResVo;

public class AuthTokenRes {

	private SysUserResVo userInfo;

	private String authToken;

	public SysUserResVo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(SysUserResVo userInfo) {
		this.userInfo = userInfo;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
}
