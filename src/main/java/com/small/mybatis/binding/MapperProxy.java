package com.small.mybatis.binding;

import com.small.mybatis.session.Configuration;
import com.small.mybatis.session.Function;
import com.small.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @ClassName MapperProxy
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 00:03
 * @Version 1.0
 **/
public class MapperProxy<T> implements InvocationHandler {
    private SqlSession sqlSession;
    private Configuration configuration;

    public MapperProxy(SqlSession sqlSession, Configuration configuration) {
        this.sqlSession = sqlSession;
        this.configuration = configuration;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (!method.getDeclaringClass().getName().equals(configuration.getMapperBean().getInterfaceName())) {
            return null;
        }

        List<Function> list = configuration.getMapperBean().getFunctions();
        if(null != list || 0 != list.size()){
            for (Function function : list) {
                //id是否和接口方法名一样
                if(method.getName().equals(function.getFuncName())){
                    MapperMethod mapperMethod = new MapperMethod(method);
                    return mapperMethod.execute(sqlSession, args);
                }
            }
        }


        return null;
    }
}