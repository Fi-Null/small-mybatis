package com.small.mybatis.datasource;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceFactory
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 21:56
 * @Version 1.0
 **/
public interface DataSourceFactory {

    DataSource getDataSource();

}
