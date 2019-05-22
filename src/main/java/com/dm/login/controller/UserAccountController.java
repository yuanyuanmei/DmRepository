package com.dm.login.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dm.login.bean.UserAccount;
import com.dm.login.service.UserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(value = "UserAccount",description = "用户帐号接口")
@RequestMapping("/UserAccount")
public class UserAccountController{

    @Autowired
    private UserAccountService UserAccountService;


    @ApiOperation(value = "查询用户帐号集合",notes = "可添加筛选条件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account",value = "帐号名称",dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "usrId",value = "用户ID",dataType = "Inteage",paramType = "path"),
    })

    @GetMapping("/list")
    public Object list(UserAccount account){
    return UserAccountService.list(account);
    }

    @ApiOperation(value = "根据用户帐号ID查询帐号")
    @ApiImplicitParam(name = "id",value = "帐号ID",required = true,dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public JSONObject get(@PathVariable(name = "id") Integer id){
    return UserAccountService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "根据用户帐号ID删除帐号")
    @ApiImplicitParam(name = "id",value = "帐号ID",required = true,dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public JSONObject delete(@PathVariable(name = "id") Integer id){
    return UserAccountService.delete(Integer.valueOf(id));
    }

    @ApiOperation(value = "注册帐号")
    @ApiImplicitParam(name = "jsonInfo",value = "帐号json对象",required = true,dataType = "json",paramType = "path")
    @PostMapping("/add")
    public JSONObject add(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return UserAccountService.insert(JSON.toJavaObject(jsonObject, UserAccount.class));
    }

    @ApiOperation(value = "修改帐号")
    @ApiImplicitParam(name = "jsonInfo",value = "帐号json对象",required = true,dataType = "json",paramType = "path")
    @PutMapping("/upd")
    public JSONObject upd(String jsonInfo){
    JSONObject jsonObject = JSONObject.parseObject(jsonInfo);
    return UserAccountService.update(JSON.toJavaObject(jsonObject, UserAccount.class));
    }


}
