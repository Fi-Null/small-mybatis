package com.small.mybatis.test.plugin;

import com.small.mybatis.plugin.Interceptor;
import com.small.mybatis.plugin.Invocation;
import com.small.mybatis.plugin.Plugin;

/**
 * @ClassName TestPlugin
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:57
 * @Version 1.0
 **/
public class TestPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        String statement = (String) invocation.getArgs()[0];
        String parameter = (String) invocation.getArgs()[1];
        Class pojo = (Class) invocation.getArgs()[2];
        System.out.println("----------plugin生效----------");
        System.out.println("executor执行query方法前拦截，拦截到的Sql语句为: " + statement);
        System.out.println("参数为: " + parameter + " 实体类为: " + pojo.getName());
        System.out.println("-----------拦截结束-----------");
        //在这里执行原executor的方法
        return invocation.proceed();
    }

    /**
     * 实际上此方法就是将此插件给target做一个动态代理
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}
