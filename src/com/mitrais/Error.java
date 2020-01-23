package com.mitrais;

public class Error {
    private boolean Error = false;
    private String ErrorMessage;

    public Error(boolean isError, String msg){
        this.Error = isError;
        this.ErrorMessage = msg;
    }

    public boolean getError(){
        return Error;
    }

    public void setError(boolean err){
        this.Error = err;
    }

    public String getErrorMessage(){
        return ErrorMessage;
    }

    public void setErrorMessage(String msg){
        this.ErrorMessage = msg;
    }
}
