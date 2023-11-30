package com.mayikt.test;

import com.mayikt.entity.MayiktUserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    public static <UserEntity> void main(String[] args) throws IOException {
        // 1.读取加载mybatis-config.xml
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.获取到获取到
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.根据 mapper id=getByUsers 执行该s  ql 语句 通过  sql语句得到我们的对象 orm

        List<MayiktUserEntity> userentity =  sqlSession.selectList("getByUsers", MayiktUserEntity.class);
        System.out.println(userentity);
        sqlSession.close();
    }
}
