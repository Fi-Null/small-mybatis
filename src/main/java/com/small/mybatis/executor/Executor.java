package com.small.mybatis.executor;

/**
 * @ClassName Executor
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:10
 * @Version 1.0
 **/
public interface Executor {

    <T> T query(String statement, String parameter, Class pojo) throws Exception;

}
