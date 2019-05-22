package com.dm.login.service;

import com.alibaba.fastjson.JSONObject;
import com.dm.login.bean.LogOperate;

public interface LogOperateService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(LogOperate t);

    JSONObject update(LogOperate t);

    JSONObject list(LogOperate t);

    JSONObject getCount(LogOperate t);
}