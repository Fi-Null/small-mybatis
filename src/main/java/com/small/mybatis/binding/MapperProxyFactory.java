package com.small.mybatis.binding;

import com.small.mybatis.session.Configuration;
import com.small.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * @ClassName MapperProxyFactory
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 00:01
 * @Version 1.0
 **/
public class MapperProxyFactory<T> {

    private Configuration configuration;

    public MapperProxyFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    private T newInstance(MapperProxy<T> mapperProxy) {
        return (T) Proxy.newProxyInstance(configuration.getMapperInterface().getClassLoader(), new Class[]{this.configuration.getMapperInterface()}, mapperProxy);
    }

    public T newInstance(SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, configuration.getSql());
        return newInstance(mapperProxy);
    }

}
