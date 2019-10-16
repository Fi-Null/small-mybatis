package com.small.mybatis.session;

import com.small.mybatis.executor.Executor;

/**
 * @ClassName SqlSession
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:09
 * @Version 1.0
 **/
public class SqlSession {

    //持有两个关键对象
    private Configuration configuration;
    private Executor executor;

    /**
     * 用构造器将两个对象形成关系
     */
    public SqlSession(Configuration configuration) {
        this.configuration = configuration;
        //这里需要决定是否开启缓存，则从Configuraton中判断是否需要缓存，创建对应Executor
        this.executor = configuration.newExecutor();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * 委派configuration获取mapper
     */
    public <T> T getMapper(Class<T> clazz) {
        return configuration.getMapper(clazz, this);
    }

    /**
     * 委派executor查询
     */
    public <T> T selectOne(String statement, String parameter, Class pojo) throws Exception {
        return executor.query(statement, parameter, pojo);
    }

}
