package com.ave.errors;


public class DetalleError {

	private Boolean hayError = Boolean.FALSE;
    private String codigoError;
    private String descError;

    public DetalleError() {
    }

    public DetalleError(String codigoError, String descError) {
        this.codigoError = codigoError;
        this.descError = descError;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    public String getDescError() {
        return descError;
    }

    public void setDescError(String descError) {
        this.descError = descError;
    }
    
    
}
