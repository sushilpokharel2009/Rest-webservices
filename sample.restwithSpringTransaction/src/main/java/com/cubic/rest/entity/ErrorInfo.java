package com.cubic.rest.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorInfo {
	private String errCode;
	private String errDesc;
	
	public  ErrorInfo() {
		
	}
	
	public ErrorInfo(String errCode, String errDesc) {
		super();
		this.errCode = errCode;
		this.errDesc = errDesc;
	}
	
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrDesc() {
		return errDesc;
	}
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	
	
}
