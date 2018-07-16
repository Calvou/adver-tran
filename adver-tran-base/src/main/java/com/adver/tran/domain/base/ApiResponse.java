package com.adver.tran.domain.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.adver.tran.common.exception.ErrorCode;
import com.adver.tran.common.utils.DateUtil;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lgf
 */
@ApiModel
public class ApiResponse<E> {

	@ApiModelProperty(required = true, notes = "业务号")
	private String bussSeqNo;
	
	@ApiModelProperty(required = true, notes = "错误信息")
    private String msg;
	
	@ApiModelProperty(required = true, notes = "错误码")
    private String code;
	
	@ApiModelProperty(required = true, notes = "渠道ID")
	private String channelId;
	
	@ApiModelProperty(required = true, notes = "业务请求时间")
	private String reqTime;
	
	@ApiModelProperty(required = true, notes = "服务器接收时间")
	private String recTime;
	
	@ApiModelProperty(required = true, notes = "服务器响应时间")
	private String respTime;
	
    private E resData;

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getBussSeqNo() {
		return bussSeqNo;
	}
	public void setBussSeqNo(String bussSeqNo) {
		this.bussSeqNo = bussSeqNo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public E getResData() {
		return resData;
	}

	public void setResData(E resData) {
		this.resData = resData;
		this.code= ErrorCode.SUCCESS.getCode();
		this.msg= ErrorCode.SUCCESS.getMessage();
		this.respTime = format(new Date(),DateUtil.DT_YYYYMMDDHHMMSSSSS);
	}
	
	
	public String format(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(date);
	}
	
	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}

	public String getRecTime() {
		return recTime;
	}

	public void setRecTime(String recTime) {
		this.recTime = recTime;
	}

	public String getRespTime() {
		return respTime;
	}

	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ApiResponse{");
		sb.append("respTime='").append(respTime).append('\'');
		sb.append(", recTime='").append(recTime).append('\'');
		sb.append(", reqTime='").append(reqTime).append('\'');
		sb.append(", channelId='").append(channelId).append('\'');
		sb.append(", code='").append(code).append('\'');
		sb.append(", msg='").append(msg).append('\'');
		sb.append(", bussSeqNo='").append(bussSeqNo).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
