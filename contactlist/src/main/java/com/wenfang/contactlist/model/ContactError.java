package com.wenfang.contactlist.model;

public class ContactError {
	private int code;
	private String errorMsg;
	
	public ContactError(int code, String errorMsg) {
		this.code = code;
		this.errorMsg = errorMsg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
