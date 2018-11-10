package com.conhj.service;

import com.conhj.model.Father;
import com.conhj.model.Husband;
import com.conhj.model.Son;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Set;

public class FathserServiceImpl {
    private SqlSessionFactory ssf;
    public FathserServiceImpl(){
        InputStream in=HusbandServiceImpl.class.getClassLoader().getResourceAsStream("mybatis.cfg.xml");
        ssf=new SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public void querySonByFather(){

        SqlSession session=ssf.openSession();
        try{
            Father f=session.selectOne("com.conhj.mapper.FatherMapper.selectByPrimaryKey","8");
            System.out.println(f.getFname());
            Set<Son> mysons=f.getSons();
            mysons.forEach(s->System.out.println(s.getSname()));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();

        }

    }
    @Test
    public void queryFatherBySon(){

        SqlSession session=ssf.openSession();
        try{
            Son s=session.selectOne("com.conhj.mapper.SonMapper.selectByPrimaryKey","7");
            System.out.println(s.getSname()+" "+s.getFather().getFname());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();

        }

    }
}
