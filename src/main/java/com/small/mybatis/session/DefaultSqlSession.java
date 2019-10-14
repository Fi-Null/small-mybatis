package com.small.mybatis.session;

import com.small.mybatis.datasource.DefaultDataSourceFactory;
import com.small.mybatis.executor.Executor;
import com.small.mybatis.executor.SimpleExecutor;
import com.small.mybatis.executor.resultset.DefaultResultHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DefaultSqlSession
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 23:27
 * @Version 1.0
 **/
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private DataSource dataSource;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration) throws SQLException {
        this.configuration = configuration;
        this.dataSource = new DefaultDataSourceFactory().getDataSource(configuration.getDataSourceName());
        this.executor = new SimpleExecutor();
    }

    public DefaultSqlSession() throws SQLException {
    }

    @Override
    public <T> T getMapper(Class<T> interfaceType) {
        return configuration.getMapper(interfaceType, this);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


    @Override
    public <T> T selectOne(Object[] args) throws Exception {
        List<T> list = executor.query(this.getConnection(), configuration, args, new DefaultResultHandler(this.configuration));
        //默认只获得第一条
        return list.get(0);
    }

    @Override
    public void close() {

    }
}