package com.conhj.service;

import com.conhj.model.Husband;
import com.conhj.model.Wife;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class HusbandServiceImpl {
    private SqlSessionFactory ssf;
    public HusbandServiceImpl(){
        InputStream in=HusbandServiceImpl.class.getClassLoader().getResourceAsStream("mybatis.cfg.xml");
        ssf=new SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public void queryWifeByHus(){

        SqlSession session=ssf.openSession();
        try{
            Husband hus=session.selectOne("com.conhj.mapper.HusbandMapper.selectByPrimaryKey","22");
            System.out.println(hus.getName());
            System.out.println(hus.getWife().getName());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();

        }

    }
    @Test
    public void addyHus(){

        SqlSession session=ssf.openSession();
        try{
            Husband hus=new Husband();
            hus.setId("22");
            hus.setName("JSS");

            Wife wife=new Wife();
            wife.setWid("22");
            wife.setName("KII");
            session.insert("com.conhj.mapper.HusbandMapper.insert",hus);
            session.insert("com.conhj.mapper.WifeMapper.insert",wife);
            session.commit();
            //System.out.println(hus.getName());
        }catch(Exception e){
            session.rollback();
            e.printStackTrace();
        }finally{
            session.close();

        }

    }


}
