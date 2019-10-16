package com.small.mybatis.binding;

import com.small.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MapperProxy
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:18
 * @Version 1.0
 **/
public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;
    private Class object;

    public MapperProxy(SqlSession sqlSession, Class object) {
        this.sqlSession = sqlSession;
        this.object = object;
    }

    /**
     * 每一个Mapper的每个方法都将执行invoke方法，此方法判断方法名是否维护在Configuration中，如有则取出SQL
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (sqlSession.getConfiguration().hasStatement(method.getDeclaringClass().getName() + "." + method.getName())) {
            String sql = sqlSession.getConfiguration().getMappedStatement(method.getDeclaringClass().getName() + "." + method.getName());
            return sqlSession.selectOne(sql, args[0].toString(), object);
        }
        return method.invoke(proxy, args);
    }
}
