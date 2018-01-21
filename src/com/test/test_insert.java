package com.test;

import com.com.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.utils.myBatisUtil;

import java.io.InputStream;

public class test_insert {
    public static void main(String[] args){
        //默认是后动提交，设置成true是自动提交
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        User user = new User();
        user.setAge(10);
        user.setName("HH");
        String statment = "com.com.mapper.UserMapper.insertUser";
        int flag = sqlSession.insert(statment,user);
        //是后动提交
        //sqlSession.commit();
        System.out.println(flag);
    }
}
