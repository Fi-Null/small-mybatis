package com.small.mybatis.executor.statement;

import com.small.mybatis.executor.parameter.ParameterHandler;
import com.small.mybatis.executor.resultset.ResultSetHandler;
import com.small.mybatis.session.Configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @ClassName RoutingStatementHandler
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 22:49
 * @Version 1.0
 **/
public class RoutingStatementHandler implements StatementHandler {

    private StatementHandler delegate;
    private Configuration configuration;

    public RoutingStatementHandler(Configuration configuration, Object args[]) {
        this.configuration = configuration;
        if (judgeStatementType())
            this.delegate = new PreparedStatementHandler(configuration, args);
        else
            this.delegate = new SimpleStatementHandler(configuration, args);
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        delegate.parameterize(statement);
    }

    @Override
    public <E> List<E> query(Statement statement, ResultSetHandler resultSetHandler) throws Exception {
        return delegate.query(statement, resultSetHandler);
    }

    @Override
    public ParameterHandler getParameterHandler() {
        return delegate.getParameterHandler();
    }

    @Override
    public Statement prepare(Connection connection) throws SQLException {
        return delegate.prepare(connection);
    }

    private boolean judgeStatementType() {
        if (configuration.getSql().contains("$"))
            return false;//statement
        return true;//preparedStatement
    }
}
