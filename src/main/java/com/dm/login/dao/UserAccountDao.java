package com.dm.login.dao;

import com.dm.login.base.BaseDao;
import com.dm.login.bean.UserAccount;

import java.util.List;

public interface UserAccountDao extends BaseDao<UserAccount> {

    UserAccount selectByPrimaryKey(Integer id);
}