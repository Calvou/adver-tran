package com.adver.tran.common.exception;

/**
 * 错误码枚举类
 * 错误码规则：4[系统标识]+2[系统序号]+4[错误编号]
 *
 * 错误编号规则
 * 01 系统
 * 02 接口
 * 03 参数
 *
 * 创建时间：2017年05月23日 下午3:54:26
 * @author zhaoweiguang
 **/

public enum ErrorCode {

    /** 编号   编号前缀   + 被调系统编号 + 异常编码 */  //1001 00 0001

	SUCCESS("1001000000","成功"),
    ERROR("1001009999","业务处理异常"),
	PARAM_ERROR("1001000001","参数错误"),
	DOUBBOERROR("1001000002","DUBBO服务无法调用"),

    ;

	private String code;
    private String message;
 
    private ErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
