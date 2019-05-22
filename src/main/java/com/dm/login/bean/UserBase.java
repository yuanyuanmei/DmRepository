package com.dm.login.bean;

import com.dm.login.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
* UserBase 实体类
* Created by auto generator on Wed May 08 21:07:55 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBase extends BaseEntity{
        /**
        * 用户名
        */
        private String username;
        /**
        * 邮箱
        */
        private String email;
        /**
        * 手机号
        */
        private String phone;
        /**
        * 用户类型(1.普通用户,2.企业用户)
        */
        private Integer type;
        /**
        * 账户头像
        */
        private String headerUrl;
}