package com.adver.tran.domain.res.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class UserResVo {
	@ApiModelProperty(required = true,notes = "用户ID")
	private String userId;
	@ApiModelProperty(required = true,notes = "用户名称")
	private String name;
	@ApiModelProperty(required = true,notes = "用户账号")
	private String account;
	@ApiModelProperty(required = true,notes = "用户密码")
	private String pwd;
	
	@ApiModelProperty(required = true,notes = "最近登录时间")
	private String lastLoginTime;
	@ApiModelProperty(required = true,notes = "最近登录IP")
	private String lastLoginIp;
	@ApiModelProperty(required = true,notes = "微信账号")
	private String chatNo;
	@ApiModelProperty(required = true,notes = "职位")
	private String userPosition;
	@ApiModelProperty(required = true,notes = "人员类型")
	private String userType;
	
	@ApiModelProperty(required = true,notes = "用户性别")
	private String sex;
	@ApiModelProperty(required = true,notes = "用户电话")
	private String phone;
	
	@ApiModelProperty(required = true,notes = "email")
	private String email;
	
	@ApiModelProperty(required = true,notes = "用户有效性")
	private String valid;
	@ApiModelProperty(required = true,notes = "用户创建时间")
	private String cr_time;
	@ApiModelProperty(required = true,notes = "用户更新时间")
	private String up_time;
	
	@ApiModelProperty(required = true,notes = "分机号(认证名)")
	private String staffuatName;
	@ApiModelProperty(required = true,notes = "认证密码")
	private String staffuatPwd;
	@ApiModelProperty(required = true,notes = "员工工号")
	private String staffNo;
	
	@ApiModelProperty(required = true,notes = "用户所属机构id")
	private String orgId;
	
	@ApiModelProperty(required = true,notes = "用户所属机构名称")
	private String orgName;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getCr_time() {
		return cr_time;
	}
	public void setCr_time(String cr_time) {
		this.cr_time = cr_time;
	}
	public String getUp_time() {
		return up_time;
	}
	public void setUp_time(String up_time) {
		this.up_time = up_time;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public String getChatNo() {
		return chatNo;
	}
	public void setChatNo(String chatNo) {
		this.chatNo = chatNo;
	}
	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStaffuatName() {
		return staffuatName;
	}
	public void setStaffuatName(String staffuatName) {
		this.staffuatName = staffuatName;
	}
	public String getStaffuatPwd() {
		return staffuatPwd;
	}
	public void setStaffuatPwd(String staffuatPwd) {
		this.staffuatPwd = staffuatPwd;
	}
	public String getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}
