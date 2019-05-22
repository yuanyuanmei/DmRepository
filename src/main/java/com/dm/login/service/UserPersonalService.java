package com.dm.login.service;

import com.alibaba.fastjson.JSONObject;
import com.dm.login.bean.UserPersonal;

public interface UserPersonalService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(UserPersonal t);

    JSONObject update(UserPersonal t);

    JSONObject list(UserPersonal t);

    JSONObject getCount(UserPersonal t);
}