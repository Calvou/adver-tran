package com.adver.tran.domain.req.vo;

import com.adver.tran.common.validation.NotDNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PageReqVo {
	@ApiModelProperty(required = true, notes = "当前页")
	@NotDNull(message = "当前页")
	private String page;
	@ApiModelProperty(required = true, notes = "每页数据条数")
	@NotDNull(message = "每页数据条数")
	private String size;
	
	public PageReqVo() {
		super();
	}
	public PageReqVo(String page, String size) {
		super();
		this.page = page;
		this.size = size;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}
