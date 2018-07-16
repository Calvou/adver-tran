package com.adver.tran.domain.res;

import java.util.List;

import com.adver.tran.domain.res.vo.UserResVo;

public class UserRes {
	private List<UserResVo> userList;

	public List<UserResVo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserResVo> userList) {
		this.userList = userList;
	}
}
