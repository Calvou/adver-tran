package com.adver.tran.domain.req;

import com.adver.tran.common.validation.NotDNull;
import com.adver.tran.domain.base.ApiRequest;
import com.adver.tran.domain.req.vo.AdverNeedReqVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class AdverNeedReq extends ApiRequest{
	
	@ApiModelProperty(required = true,notes = "业务数据")
	@NotDNull(message = "业务数据不能为空")
	private AdverNeedReqVo reqData;

	public AdverNeedReqVo getReqData() {
		return reqData;
	}

	public void setReqData(AdverNeedReqVo reqData) {
		this.reqData = reqData;
	}
	
}
