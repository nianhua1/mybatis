package com.teng.mybatis.test;

import com.teng.mybatis.bean.User;
import com.teng.mybatis.dao.UserDynamicSQLMapper;
import com.teng.mybatis.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MybatisTest {

    @Test
    public void test() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            List<User> emps = mapper.getEmps();
            for (User emp : emps) {
                System.out.println(emp);
            }
        } finally {
            openSession.close();
        }

    }
    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = openSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
    }

    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            //测试添加
            //mapper.addUser(new User(null,"nianhua","nianhua@qq.com","1"));
            //测试修改
            //mapper.updateUser(new User(4,"七里香","qlx@qq.com","0") );
            //测试删除
            mapper.deleteUserById(5);
            mapper.deleteUserById(6);
        } finally {
            openSession.close();
        }


    }

    @Test
    public void test3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);

        try {
            UserDynamicSQLMapper mapper = openSession.getMapper(UserDynamicSQLMapper.class);
            //User user = mapper.getUserByCondition(new User(null, "%a%", null, null));
           // System.out.println(user);
            List<User> list = new ArrayList<>();
            list.add(new User(null,"夜曲","yequ@163.com","0"));
            list.add(new User(null,"枫","feng@163.com","1"));
            list.add(new User(null,"Ali","ali@qq.com","1"));
            list.add(new User(null,"Taozi","taozi@qq.com","0"));
            mapper.batchUser(list);
        } finally {
            openSession.close();
        }


    }
}
