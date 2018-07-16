package com.adver.tran.domain.req;

import com.adver.tran.common.validation.NotDNull;
import com.adver.tran.domain.base.ApiRequest;
import com.adver.tran.domain.req.vo.ChangePWDReqVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ChangePWDReq extends ApiRequest{

	@ApiModelProperty(required = true,notes = "业务数据")
	@NotDNull(message = "业务数据不能为空")
	private ChangePWDReqVo reqData;

	public ChangePWDReqVo getReqData() {
		return reqData;
	}

	public void setReqData(ChangePWDReqVo reqData) {
		this.reqData = reqData;
	}
	
	
}
