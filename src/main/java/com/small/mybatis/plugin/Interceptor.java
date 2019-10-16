package com.small.mybatis.plugin;

/**
 * @ClassName Interceptor
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:23
 * @Version 1.0
 **/
public interface Interceptor {

    Object intercept(Invocation invocation) throws Throwable;

    Object plugin(Object target);

}
