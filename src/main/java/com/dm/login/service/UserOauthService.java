package com.dm.login.service;

import com.alibaba.fastjson.JSONObject;
import com.dm.login.bean.UserOauth;

public interface UserOauthService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(UserOauth t);

    JSONObject update(UserOauth t);

    JSONObject list(UserOauth t);

    JSONObject getCount(UserOauth t);
}