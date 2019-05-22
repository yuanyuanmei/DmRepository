package com.dm.login.service;

import com.alibaba.fastjson.JSONObject;
import com.dm.login.bean.LogLogin;

public interface LogLoginService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(LogLogin t);

    JSONObject update(LogLogin t);

    JSONObject list(LogLogin t);

    JSONObject getCount(LogLogin t);
}