package com.dm.login.service;

import com.alibaba.fastjson.JSONObject;
import com.dm.login.bean.UserRole;

public interface UserRoleService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(UserRole t);

    JSONObject update(UserRole t);

    JSONObject list(UserRole t);

    JSONObject getCount(UserRole t);
}