package com.dm.login.service;

import com.alibaba.fastjson.JSONObject;
import com.dm.login.bean.UserBase;

public interface UserBaseService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(UserBase t);

    JSONObject update(UserBase t);

    JSONObject list(UserBase t);

    JSONObject getCount(UserBase t);
}