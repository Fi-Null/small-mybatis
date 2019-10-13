package com.small.mybatis.binding;

import com.small.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MapperProxy
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 00:03
 * @Version 1.0
 **/
public class MapperProxy<T> implements InvocationHandler {
    private SqlSession sqlSession;
    private String sql;

    public MapperProxy(SqlSession sqlSession, String sql) {
        this.sqlSession = sqlSession;
        this.sql = sql;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperMethod mapperMethod = new MapperMethod(method);
        return mapperMethod.execute(sqlSession, args);
    }
}