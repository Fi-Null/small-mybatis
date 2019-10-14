package com.small.mybatis.session;

import java.sql.SQLException;

/**
 * @ClassName DefaultSqlSessionFactory
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 23:26
 * @Version 1.0
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;


    public DefaultSqlSessionFactory() throws ClassNotFoundException {
        this.configuration = new Configuration();
    }

    @Override
    public SqlSession openSession() throws SQLException {
        return new DefaultSqlSession(configuration);
    }
}
