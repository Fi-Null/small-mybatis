package com.small.mybatis.session;

/**
 * @ClassName SqlSessionFactoryBuilder
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 23:26
 * @Version 1.0
 **/
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build() throws ClassNotFoundException {
        return new DefaultSqlSessionFactory();
    }

}
