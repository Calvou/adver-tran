package com.adver.tran.common.exception;

import java.text.MessageFormat;



/**
 * Created by lgf
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;

	public BusinessException(Exception e){
		super(e);
		this.errorCode = ErrorCode.ERROR.getCode();
		this.errorMessage = ErrorCode.ERROR.getMessage();
	}

	public BusinessException(ErrorCode eCode){
		super(eCode.getCode() + ":" + eCode.getMessage());
		this.errorCode = eCode.getCode();
		this.errorMessage = eCode.getMessage();
	}

	public BusinessException(ErrorCode eCode, String... msg){
		super(eCode.getCode() + ":" + MessageFormat.format(eCode.getMessage(), msg));
		this.errorCode = eCode.getCode();
		this.errorMessage = MessageFormat.format(eCode.getMessage(), msg);
	}

	public BusinessException(String errorCode, String errorMessage) {
		super(errorCode + ":" + errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
    public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
