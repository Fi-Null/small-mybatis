package com.small.mybatis.executor.statement;

import com.small.mybatis.executor.resultset.ResultSetHandler;
import com.small.mybatis.session.Configuration;
import com.small.mybatis.util.ParametersUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PreparedStatementHandler
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 22:50
 * @Version 1.0
 **/
public class PreparedStatementHandler extends BaseStatementHandler {
    public PreparedStatementHandler(Configuration conf, Object[] args) {
        super(conf, args);
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        this.getParameterHandler().setParameters((PreparedStatement) statement);
    }

    @Override
    public <E> List<E> query(Statement statement, ResultSetHandler resultSetHandler) throws Exception {
        return resultSetHandler.handleResultSets(statement);
    }

    @Override
    public Statement prepare(Connection connection) throws SQLException {
        String sql = configuration.get();
        Map<String, Integer> parameterMap = new HashMap<>();
        sql = ParametersUtil.preparedStatementSql(sql, parameterMap);
        configuration.setSql(sql);
        return connection.prepareStatement(sql);
    }

}
