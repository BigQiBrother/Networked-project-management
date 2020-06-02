package com.agile.agiletest.dao;

import com.agile.agiletest.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserDao {

    /**
     * 通过username查询User信息
     *
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User getUserByUsername(String username);

    /**
     * 注册用户信息
     *
     * @param user
     * @return
     */
    @Insert("insert into user (username, password, person_id) values(#{username}, #{password}, #{personId})")
    int insertUserRegisterInfo(User user);

    /**
     * 更新用户账户信息
     *
     * @param user
     * @return
     */
    int updateUserRegisterInfo(User user);








}
