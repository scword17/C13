package com.conhj.service;

import com.conhj.model.User;
import com.conhj.model.UserExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserService {
    private static SqlSessionFactory sessionFactory;
    public UserService(){
        InputStream in=UserService.class.getClassLoader().getResourceAsStream("mybatis.cfg.xml");
        sessionFactory=new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void addUser(){
        SqlSession session=sessionFactory.openSession();
        try{
            User user=new User();
            user.setId(199);
            user.setPwd("user199");
            session.insert("insert",user);
            session.commit();
        }catch(Exception e){
            session.rollback();
            e.printStackTrace();
        }finally{
            session.close();

        }

    }
    @Test
    public void delUser(){
        SqlSession session=sessionFactory.openSession();
        try{
            User user=new User();
            user.setId(199);
            session.delete("deleteByPrimaryKey",user);
            session.commit();
        }catch(Exception e){
            session.rollback();
            e.printStackTrace();
        }finally{
            session.close();

        }

    }
    @Test
    public void updateUser(){
        SqlSession session=sessionFactory.openSession();
        try{
            User user=new User();
            user.setId(199);
            user.setName("user199");
            user.setPwd("useur");
            user.setAge(18);
            session.update("updateByPrimaryKeySelective",user);
            session.commit();
        }catch(Exception e){
            session.rollback();
            e.printStackTrace();
        }finally{
            session.close();

        }

    }
    @Test
    public void queryById(){
        SqlSession session=sessionFactory.openSession();
        try{
            User user=session.selectOne("selectByPrimaryKey",199);
            System.out.println(user.getName()+" "+user.getPwd());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();

        }

    }
    @Test
    public void queryAll(){
        SqlSession session=sessionFactory.openSession();
        try{
            UserExample example=new UserExample();
            example.createCriteria().andNameLike("%w%");
            List<User> list1=session.selectList("selectByExample",example);
            list1.forEach(s->System.out.println(s.getName()));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();

        }

    }




}
