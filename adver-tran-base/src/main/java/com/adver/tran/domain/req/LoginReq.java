package com.adver.tran.domain.req;


import com.adver.tran.common.validation.NotDNull;
import com.adver.tran.domain.base.ApiRequest;
import com.adver.tran.domain.req.vo.LoginReqVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class LoginReq extends ApiRequest{

	@ApiModelProperty(required = true,notes = "业务数据")
	@NotDNull(message = "业务数据不能为空")
	private LoginReqVo reqData;

	public LoginReqVo getReqData() {
		return reqData;
	}

	public void setReqData(LoginReqVo reqData) {
		this.reqData = reqData;
	}
		
}
