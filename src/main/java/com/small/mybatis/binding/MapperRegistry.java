package com.small.mybatis.binding;

import com.small.mybatis.session.Configuration;
import com.small.mybatis.session.SqlSession;

/**
 * @ClassName MapperRegistry
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/13 23:58
 * @Version 1.0
 **/
public class MapperRegistry {

    private Configuration configuration;

    public MapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> T getMapper(Class<T> interfaceType, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = new MapperProxyFactory<T>(configuration);
        return mapperProxyFactory.newInstance(sqlSession);
    }


}
