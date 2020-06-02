package com.agile.agiletest.controller;


import com.agile.agiletest.Result.Result;
import com.agile.agiletest.config.data.DataSource;
import com.agile.agiletest.config.data.DataSourceNames;
import com.agile.agiletest.pojo.Person;
import com.agile.agiletest.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/updateUserInfo")
    @DataSource(DataSourceNames.ONE)
    public Result updateUserInfo(@RequestBody JSONObject jsonObject){
        Result result = null;
        String username = jsonObject.getString("username");
        String trueName = jsonObject.getString("trueName");
        String idCardNum = jsonObject.getString("idCardNum");
        String phoneNum = jsonObject.getString("phoneNum");
        Integer age = jsonObject.getInteger("age");
        Person person = new Person(trueName, idCardNum, phoneNum, age);
        result = userService.updateUserInfo(username,person);
        return result;
    }

    @PostMapping("/getpersoninfo")
    @DataSource(DataSourceNames.TWO)
    public Result getPersonInfo(@RequestBody JSONObject jsonObject){
        return userService.getPersonInfo(jsonObject.getString("username"));
    }


}
