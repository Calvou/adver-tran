package com.adver.tran.domain.base;

import com.adver.tran.common.validation.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lgf
 */
@ApiModel
public class ApiRequest {
	
	/**
     * 业务流水号
     */
    @ApiModelProperty(required = true,notes = "业务流水号")
    @NotEmpty(message = "业务流水号不能为空")
    protected String bussSeqNo;

    /**
     * 渠道ID
     */
    @ApiModelProperty(required = true,notes = "渠道ID]")
    @NotEmpty(message = "渠道ID不能为空")
    protected String channelId;
	
    /**
     * 请求时间
     */
    @ApiModelProperty(required = true,notes = "请求时间 格式:[yyyyMMddHHmmssSSS]")
    @NotEmpty(message = "请求时间不能为空")
    protected String reqTime;
    
    /**
     * 请求签名
     */
    @ApiModelProperty(required = true,notes = "请求签名-秘钥验证 -bussSeqNo-channelId-reqTime-JSONString(data)-key")
    protected String reqSign;

	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}

	public String getReqSign() {
		return reqSign;
	}

	public void setReqSign(String reqSign) {
		this.reqSign = reqSign;
	}

	public String getBussSeqNo() {
		return bussSeqNo;
	}

	public void setBussSeqNo(String bussSeqNo) {
		this.bussSeqNo = bussSeqNo;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
}
