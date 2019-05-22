package com.dm.login.bean;

import com.dm.login.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
* LogOperate 实体类
* Created by auto generator on Wed May 08 21:07:54 CST 2019.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogOperate extends BaseEntity{
        private Integer usrId;
        /**
        * 操作类型(1.绑定,2.解绑,3.改密,4.审核)
        */
        private Integer type;
        /**
        * 操作模块
        */
        private String module;
        /**
        * 操作前内容
        */
        private String oldContent;
        /**
        * 操作后内容
        */
        private String newContent;
        /**
        * 操作状态(1.成功2.失败)
        */
        private Integer successStatus;
        /**
        * 备注
        */
        private String note;
}