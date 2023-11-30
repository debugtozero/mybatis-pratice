package com.mayikt.service;

import com.mayikt.entity.FlightEntity;
import com.mayikt.mapper.FlightMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FlightService {
    private FlightMapper flightMapper;

    public FlightService() throws IOException {
        // 通过无参构造方法 初始化mybatis 得到flightMapper
        // mybatis-config.xml 目录位置
        String resource = "mybatis-config.xml";
        // 1.解析mybatis-config.xml 得到数据库相关的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2.创建得到一个sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.获取到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        flightMapper = sqlSession.getMapper(FlightMapper.class);
//        sqlSession.close();
    }


    public List<FlightEntity> getByFlightAll() {
        return flightMapper.getByFlightAll();
    }
}
