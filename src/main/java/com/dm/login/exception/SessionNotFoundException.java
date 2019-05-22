package com.dm.login.exception;

import lombok.Getter;
import lombok.Setter;

public class SessionNotFoundException extends Exception {
    @Getter
    @Setter
    protected String message;

    public SessionNotFoundException(){
        setMessage("session is not found!");
    }

    public SessionNotFoundException(String message){
        this.message = message;
    }
}
