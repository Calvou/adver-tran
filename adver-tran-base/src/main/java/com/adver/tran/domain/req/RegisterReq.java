package com.adver.tran.domain.req;

import com.adver.tran.common.validation.NotDNull;
import com.adver.tran.domain.base.ApiRequest;
import com.adver.tran.domain.req.vo.RegisterReqVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RegisterReq extends ApiRequest{

	@ApiModelProperty(required = true,notes = "业务数据")
	@NotDNull(message = "业务数据不能为空")
	private RegisterReqVo reqData;

	public RegisterReqVo getReqData() {
		return reqData;
	}

	public void setReqData(RegisterReqVo reqData) {
		this.reqData = reqData;
	}
		
}
