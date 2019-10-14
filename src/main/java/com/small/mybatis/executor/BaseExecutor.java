package com.small.mybatis.executor;

import com.small.mybatis.executor.resultset.ResultSetHandler;
import com.small.mybatis.session.Configuration;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName BaseExecutor
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 23:29
 * @Version 1.0
 **/
public abstract class BaseExecutor implements Executor {
    private Configuration configuration;

    @Override
    public <E> List<E> query(Connection connection, Configuration conf, Object[] args, ResultSetHandler resultSetHandler) throws Exception {
        List<E> list = queryFromDatabase(connection, conf, args, resultSetHandler);
        return list;
    }

    public <E> List<E> queryFromDatabase(Connection connection, Configuration conf, Object[] args, ResultSetHandler resultSetHandler) throws Exception {
        return doQuery(connection, conf, args, resultSetHandler);
    }

    protected abstract <E> List<E> doQuery(Connection connection, Configuration conf, Object[] args, ResultSetHandler resultSetHandler) throws Exception;

}