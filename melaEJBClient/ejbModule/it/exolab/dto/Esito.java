package it.exolab.dto;

import java.io.Serializable;

public class Esito implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1719177415293462540L;
	private boolean success = false;
	private String errCode = "";
	private String error;
	private Object data;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Esito [success=" + success + ", errCode=" + errCode + ", error=" + error + ", data=" + data + "]";
	}
	
	

}
