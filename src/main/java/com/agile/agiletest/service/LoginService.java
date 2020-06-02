package com.agile.agiletest.service;

import com.agile.agiletest.Result.Result;
import com.agile.agiletest.pojo.User;


public interface LoginService {
    /**
     * 登录处理
     *
     * @return
     */
    Result loginIn(User userData);


    /**
     * 更新用户信息
     *
     * @param userData
     * @return
     */
    Result updateUser(User userData, String passwordNew);

    /**
     * regist user info
     *
     * @param userData
     * @return
     */
    Result registUser(User userData);
}
