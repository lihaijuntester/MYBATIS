package com.test;
import com.com.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.utils.myBatisUtil;
import org.junit.Test;

import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;

public class test_select {
    public static void main(String[] args) throws IOException{
        SqlSession sqlSession = myBatisUtil.getFactory().openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
         String statement = "com.com.mapper.UserMapper.getUser";
         User user = sqlSession.selectOne(statement,1);
         System.out.println(user);
    }
}
