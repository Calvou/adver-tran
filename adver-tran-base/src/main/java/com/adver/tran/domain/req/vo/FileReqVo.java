package com.adver.tran.domain.req.vo;

import com.adver.tran.domain.base.ApiBaseReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FileReqVo extends ApiBaseReq{

	@ApiModelProperty(required = true,notes = "文件ID")
	private String id ;
	@ApiModelProperty(required = true,notes = "需求ID")
	private String needId ;
	@ApiModelProperty(required = true,notes = "文件类型-等")
	private String type ;
	@ApiModelProperty(required = true,notes = "文件描述")
	private String desc ;
	@ApiModelProperty(required = true,notes = "文件序号-同一类型中文件的顺序【01-99】")
	private String xh ;
	@ApiModelProperty(required = true,notes = "文件内容-BASE64")
	private String content ;
	@ApiModelProperty(required = true,notes = "文件MD5")
	private String md5 ;
	@ApiModelProperty(required = true,notes = "文件后缀名")
	private String suffix ;
	@ApiModelProperty(required = true,notes = "文件原始名字")
	private String name ;
	
	public String getNeedId() {
		return needId;
	}
	public void setNeedId(String needId) {
		this.needId = needId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
