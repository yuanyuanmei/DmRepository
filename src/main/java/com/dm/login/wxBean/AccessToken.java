package com.dm.login.wxBean;

import lombok.Data;

@Data
public class AccessToken {

    private String accessToken;

    private long expiresTime;

    public AccessToken(String accessToken,String expiresIn){
        super();
        this.accessToken = accessToken;
        this.expiresTime = System.currentTimeMillis() + Integer.valueOf(expiresIn) * 1000;
    }

    public boolean isExpired(){
        return System.currentTimeMillis()>this.expiresTime;
    }
}
