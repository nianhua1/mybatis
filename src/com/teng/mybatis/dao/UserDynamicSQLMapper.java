package com.teng.mybatis.dao;

import com.teng.mybatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDynamicSQLMapper {
    public User getUserByCondition(User user);

    public void batchUser(@Param("ulist") List<User> users);
}
