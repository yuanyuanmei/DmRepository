package com.dm.login.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.dm.login.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
* UserAccount 实体类
* Created by auto generator on Wed May 08 21:07:55 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAccount extends BaseEntity{
        /**
        * 关联用户ID
        */
        @NotNull(message = "usrId不能为空")
        private Integer usrId;
        /**
        * 账号
        */
        @NotNull
        @NotBlank(message = "账号不能为空")
        @JSONField(serialize = false)
        private String account;
        /**
        * 密码
        */
        private String password;
        /**
        * 加盐次数
        */
        private String salt;
        /**
        * 明文密码
        */
        private String openPwd;
        /**
        * 最后一次登录IP
        */
        private String lastLoginIp;
        /**
        * 最后一次登录时间
        */
        @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        private Date lastLoginTime;
}