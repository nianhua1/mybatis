package com.teng.mybatis.dao;

import com.teng.mybatis.bean.User;

import java.util.List;

public interface UserMapper {
    public User getUserById(Integer id);

    public List<User> getEmps();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUserById(Integer id);
}
