package com.dm.login.service;

import com.alibaba.fastjson.JSONObject;
import com.dm.login.bean.UserBinding;

public interface UserBindingService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(UserBinding t);

    JSONObject update(UserBinding t);

    JSONObject list(UserBinding t);

    JSONObject getCount(UserBinding t);
}