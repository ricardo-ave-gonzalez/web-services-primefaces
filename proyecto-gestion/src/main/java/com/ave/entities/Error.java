package com.ave.entities;

public class Error {

	private Boolean hayError = Boolean.FALSE;
	private String codigoError;
	private String msgError;
	
	public Boolean getHayError() {
		return hayError;
	}
	public void setHayError(Boolean hayError) {
		this.hayError = hayError;
	}
	public String getCodigoError() {
		return codigoError;
	}
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}
	public String getMsgError() {
		return msgError;
	}
	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
	
}
