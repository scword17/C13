package com.conhj.service;

import com.conhj.model.Course;
import com.conhj.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Set;

public class StudentServiceImpl {
    private SqlSessionFactory ssf;
    public StudentServiceImpl(){
        InputStream in=HusbandServiceImpl.class.getClassLoader().getResourceAsStream("mybatis.cfg.xml");
        ssf=new SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public void queryCouByStu(){

        SqlSession session=ssf.openSession();
        try{
            Student stu=session.selectOne("com.conhj.mapper.StudentMapper.selectByPrimaryKey","40");
            System.out.println(stu.getSname());
            Set<Course> cous=stu.getCourses();
            cous.forEach(s->System.out.println(s.getCname()));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();

        }

    }
    @Test
    public void queryStusByCou(){

        SqlSession session=ssf.openSession();
        try{
            Course cou=session.selectOne("com.conhj.mapper.CourseMapper.selectByPrimaryKey","1");
            System.out.println(cou.getCname());
            Set<Student> cous=cou.getStus();
            cous.forEach(s->System.out.println(s.getSname()));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();

        }

    }
}
