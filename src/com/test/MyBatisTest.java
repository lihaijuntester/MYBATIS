package com.test;

import com.com.Enum.AddressEnum;
import com.com.Enum.CityEnum;
import com.com.Enum.LastNameEnum;
import com.com.Enum.FirstNameEnum;
import com.com.entity.Classes;
import com.com.entity.Persons;
import com.com.entity.User;
import com.utils.myBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;
import org.apache.log4j.Logger;


/**
 * Created by arvin on 2018/1/3.
 */
public class MyBatisTest {

   private static final Logger logger = Logger.getLogger(MyBatisTest.class);

    @Test
    public void test_select(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession();
        String statement = "com.com.mapper.UserMapper.getUser";
        User user = sqlSession.selectOne(statement,1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void test_insert(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        User user = new User();
        user.setAge(FirstNameEnum.NAME1.getIndex());
        user.setName(FirstNameEnum.NAME1.getMsg());
        String statment = "com.com.mapper.UserMapper.insertUser";
        int flag = sqlSession.insert(statment,user);
        //是后动提交
        //sqlSession.commit();
        System.out.println(flag);
        sqlSession.close();
    }
    @Test
    public void test_update(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        User user = new User();
        user.setId(7);
        user.setAge(60);
        String statment ="com.com.mapper.UserMapper.updateUser";
        sqlSession.update(statment,user);
        sqlSession.close();
    }
    @Test
    public void test_delete(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        User user = new User();
        user.setId(7);
        String statment = "com.com.mapper.UserMapper.deleteUser";
        sqlSession.delete(statment,user);
        sqlSession.close();
    }
    @Test
    public void test_getAllUser(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        String statment = "com.com.mapper.UserMapper.getUserAll";
        User user = new User();
        user.setAge(10);
        List<User> list = sqlSession.selectList(statment,user);
        //System.out.print(list);
        sqlSession.close();
        User user1=list.get(1);
        System.out.println(user1);
        System.out.println(user1.getName()+user1.getAge()+user1.getId());
    }
    //测试sql里使用别名的功能；
    @Test
    public void test_getPersons(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        String statment = "com.com.mapper.PersonsMapper.getPerson";
        Persons persons = new Persons();
        persons.setId(3);
        Persons persons1=sqlSession.selectOne(statment,persons);
        sqlSession.close();
       System.out.println(persons1);
    }
    @Test
    public void test_getPersonsResultMap(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        String statment = "com.com.mapper.PersonsMapper.getPesonsResultMap";
        Persons persons = new Persons();
        persons.setId(4);
        Persons persons1 = sqlSession.selectOne(statment,persons);
        sqlSession.close();
        //System.out.println(persons1);
        logger.info(persons1);

    }
    @Test
    public void test_insertPersonResultMap(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        String statment = "com.com.mapper.PersonsMapper.insertPesonsResultMap";
        Persons persons = new Persons();
        persons.setL_name(LastNameEnum.PERSON1.getName());
        persons.setF_name(FirstNameEnum.NAME1.getMsg());
        persons.setA_addres(AddressEnum.Address0.getAddress());
        persons.setC_city(CityEnum.BLANK.getName());
        int count = sqlSession.insert(statment,persons);
        sqlSession.close();
        logger.info(count);
    }
    @Test
    //联表查询的例子,使用一次select查询出来
    public void test_getTeacherandClassResultMap(){
      SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
      String statment = "com.com.mapper.TeacherMapper.getTeacheMapper";
      Classes classes = new Classes();
      classes = sqlSession.selectOne(statment,1);
      logger.info(classes);
      sqlSession.close();
    }
    @Test
    //联表查询的例子,使用两次select查询出来
    public void test_getTeacherClassResultMap2(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        String statment = "com.com.mapper.TeacherMapper.getClasessMapper";
        Classes classes = new Classes();
        classes = sqlSession.selectOne(statment,1);
        logger.info(classes);
        //sqlSession.close();

    }
}
