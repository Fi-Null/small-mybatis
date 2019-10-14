package com.small.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @ClassName ResultSetHandler
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 22:29
 * @Version 1.0
 **/
public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement statement) throws SQLException, IllegalAccessException, InstantiationException, Exception;

}
