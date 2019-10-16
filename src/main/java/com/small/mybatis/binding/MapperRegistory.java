package com.small.mybatis.binding;

import com.small.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapperRegistory
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:17
 * @Version 1.0
 **/
public class MapperRegistory {

    //用一个Map维护所有Mapper
    private final Map<Class<?>, MapperProxyFactory> knownMappers = new HashMap<>();

    /**
     * Configuration解析anontation之后调用此方法更新knownMappers
     */
    public <T> void addMapper(Class<T> clazz, Class pojo) {
        knownMappers.put(clazz, new MapperProxyFactory(clazz, pojo));
    }

    /**
     * getMapper最底层执行者，获取mapper的MapperProxyFactory对象
     */
    public <T> T getMapper(Class<T> clazz, SqlSession sqlSession) {
        MapperProxyFactory proxyFactory = knownMappers.get(clazz);
        if (proxyFactory == null) {
            throw new RuntimeException("Type: " + clazz + " can not find");
        }
        return (T) proxyFactory.newInstance(sqlSession);
    }

    /**
     * 内部类实现一个Factory生成Mapper的代理
     */
    public class MapperProxyFactory<T> {
        private Class<T> mapperInterface;
        private Class object;

        public MapperProxyFactory(Class<T> mapperInterface, Class object) {
            this.mapperInterface = mapperInterface;
            this.object = object;
        }

        public T newInstance(SqlSession sqlSession) {
            return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, new MapperProxy(sqlSession, object));
        }
    }

}
