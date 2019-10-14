package com.small.mybatis.session;

import java.sql.SQLException;

/**
 * @ClassName SqlSessionFactory
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 23:25
 * @Version 1.0
 **/
public interface SqlSessionFactory {

    SqlSession openSession() throws SQLException;

}
