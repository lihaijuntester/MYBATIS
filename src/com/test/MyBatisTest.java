package com.test;

import com.com.Enum.AddressEnum;
import com.com.Enum.CityEnum;
import com.com.Enum.LastNameEnum;
import com.com.Enum.FirstNameEnum;
import com.com.entity.*;
import com.utils.myBatisUtil;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.ognl.IntHashMap;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.omg.CORBA.PUBLIC_MEMBER;


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
    @Test
    public void test_getStudent(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        String statment = "com.com.mapper.GetStudents.GetStudentmap";
        Classes classes = new Classes();
        classes.setId(1);
        Classes classes1 = sqlSession.selectOne(statment,classes);
        logger.info(classes1);
        Classes classes2 = new Classes();
        classes2.setId(classes1.getId());
        classes2.setName(classes1.getName());
        classes2.setTeacher(classes1.getTeacher());
        List list = classes1.getList();
        for (int i = 0 ; i < list.size();i++){
            logger.info(list.get(i));
        }
    }
    @Test
    /*模糊查询的操作*/
    public void test_getGoodmap(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        String statment  ="com.com.mapper.QueryCondtion.Getgoodmap";
        String name = "o";
        name = null;
        QueryCondtion queryCondtion = new QueryCondtion("%"+name+"%",23,13);
        List<User>  list = sqlSession.selectList(statment,queryCondtion);
        logger.info(list);
        sqlSession.close();
    }
    @Test
    /*调用的数据库的存储过程，主要是把入参在设置是map的类型，并且没有值的初始给他付一个-1，并且把入参的值入到一个map里*/
    public void test_call_sqlcache(){
        SqlSession sqlSession = myBatisUtil.getFactory().openSession(true);
        String statment= "com.com.mapper.Puser.GetUserCount";
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("sexid",1);
        map.put("usercount",-1);
        System.out.println(map);
        sqlSession.selectOne(statment,map);
       // map.get("usercount");
        System.out.println(map.get("usercount"));
    }
}
