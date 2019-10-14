package com.small.mybatis.executor;

import com.small.mybatis.executor.resultset.ResultSetHandler;
import com.small.mybatis.session.Configuration;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName Executor
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 23:28
 * @Version 1.0
 **/
public interface Executor {

    <E> List<E> query(Connection connection, Configuration conf, Object[] args, ResultSetHandler resultSetHandler) throws Exception;
}
