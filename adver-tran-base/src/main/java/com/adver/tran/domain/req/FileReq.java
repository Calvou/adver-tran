package com.adver.tran.domain.req;

import com.adver.tran.common.validation.NotDNull;
import com.adver.tran.domain.base.ApiRequest;
import com.adver.tran.domain.req.vo.FileReqVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FileReq  extends ApiRequest{
	@ApiModelProperty(required = true,notes = "业务数据")
	@NotDNull(message = "业务数据不能为空")
	private FileReqVo reqData;

	public FileReqVo getReqData() {
		return reqData;
	}

	public void setReqData(FileReqVo reqData) {
		this.reqData = reqData;
	}
	
}
