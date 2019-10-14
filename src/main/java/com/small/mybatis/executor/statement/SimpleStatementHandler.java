package com.small.mybatis.executor.statement;

import com.small.mybatis.executor.resultset.ResultSetHandler;
import com.small.mybatis.session.Configuration;
import com.small.mybatis.util.ParametersUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SimpleStatementHandler
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 22:47
 * @Version 1.0
 **/
public class SimpleStatementHandler extends BaseStatementHandler {
    public SimpleStatementHandler(Configuration conf, Object[] args) {
        super(conf, args);
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        String sql = this.getConfiguration().getSql();
        Map<String, Integer> parameterMap = new HashMap<>();
        sql = ParametersUtil.statementSql(sql, parameterMap, this.args);
        configuration.setSql(sql);
    }

    @Override
    public <E> List<E> query(Statement statement, ResultSetHandler resultSetHandler) throws Exception {
        return resultSetHandler.handleResultSets(statement);
    }

    @Override
    public Statement prepare(Connection connection) throws SQLException {
        return connection.createStatement();
    }

}
