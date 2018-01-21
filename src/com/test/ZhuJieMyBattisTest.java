package com.test;

import com.com.entity.User;
import com.utils.myBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import test.com.UserMapper;

import javax.jws.soap.SOAPBinding;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by arvin on 2018/1/6.
 * 使有注解进行增册子改查
 */
public class ZhuJieMyBattisTest {
    @Test
    public void  addUser(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setAge(15);
        user.setName("lijingnan");
        int add = mapper.addUser(user);
        System.out.println(add);
        sqlSession.close();
    }
    @Test
    public void SelectUser(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(10);
        User user1 = mapper.SelectUser(user);
        System.out.println(user1);
        sqlSession.close();
    }
    @Test
    public void DeleteUser(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(10);
        int count = userMapper.DeleteUser(user);
        System.out.println(count);
    }
    @Test
    public void UpdateUser(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user =new User();
        user.setId(6);
        user.setAge(61);
        int count = userMapper.UpdateUser(user);
        System.out.println(count);
    }
    @Test
    public void SelectAll(){
    SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    User user = new User();
    user.setAge(10);
    List<User>  list = userMapper.SelectAll(user);
    //System.out.println(list);
    // for(int i = 0 ; i< list.size();i++) //第一种循环
        // System.out.println(list.get(i));
   // Iterator it = list.iterator();  //第二种循环
    //while (it.hasNext())
    //    System.out.println(it.next());
    for (User O :list)  //第三种循环
        System.out.println(O);
    }
}
