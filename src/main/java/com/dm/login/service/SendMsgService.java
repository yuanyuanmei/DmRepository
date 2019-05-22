package com.dm.login.service;

import com.alibaba.fastjson.JSONObject;
import com.dm.login.bean.SendMsg;

public interface SendMsgService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(SendMsg t);

    JSONObject update(SendMsg t);

    JSONObject list(SendMsg t);

    JSONObject getCount(SendMsg t);
}