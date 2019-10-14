package com.small.mybatis.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName ParameterHandler
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 22:28
 * @Version 1.0
 **/
public interface ParameterHandler {

    void setParameters(PreparedStatement ps) throws SQLException;

}
