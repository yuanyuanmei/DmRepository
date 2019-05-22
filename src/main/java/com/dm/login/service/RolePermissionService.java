package com.dm.login.service;

import com.alibaba.fastjson.JSONObject;
import com.dm.login.bean.RolePermission;

public interface RolePermissionService{
    JSONObject selectByPrimaryKey(Integer id);

    JSONObject delete(Integer id);

    JSONObject insert(RolePermission t);

    JSONObject update(RolePermission t);

    JSONObject list(RolePermission t);

    JSONObject getCount(RolePermission t);
}