package com.small.mybatis.executor.statement;

import com.small.mybatis.executor.parameter.ParameterHandler;
import com.small.mybatis.executor.resultset.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @ClassName StatementHandler
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 22:41
 * @Version 1.0
 **/
public interface StatementHandler {

    void parameterize(Statement statement) throws SQLException;

    <E> List<E> query(Statement statement, ResultSetHandler resultSetHandler) throws Exception;

    ParameterHandler getParameterHandler();

    Statement prepare(Connection connection) throws SQLException;

}
