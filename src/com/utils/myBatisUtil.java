package com.utils;

import com.test.test_insert;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by arvin on 2018/1/3.
 */
public class myBatisUtil {
    public static SqlSessionFactory getFactory() {
        //mybatis下的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件
        InputStream inputStream = test_insert.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sessionFactory;
    }
}
