package com.dm.login.service;

import com.alibaba.fastjson.JSONObject;
import com.dm.login.bean.Role;

public interface RoleService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(Role t);

    JSONObject update(Role t);

    JSONObject list(Role t);

    JSONObject getCount(Role t);
}