package com.small.mybatis.executor.parameter;

import com.small.mybatis.session.Configuration;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName DefaultParameterHandler
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 22:28
 * @Version 1.0
 **/
public class DefaultParameterHandler implements ParameterHandler {

    private Configuration configuration;
    private Object[] args;

    public DefaultParameterHandler(Configuration configuration, Object[] args) {
        this.configuration = configuration;
        this.args = args;
    }

    @Override
    public void setParameters(PreparedStatement ps) throws SQLException {
        String sql = configuration.getSql();
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
    }
}
