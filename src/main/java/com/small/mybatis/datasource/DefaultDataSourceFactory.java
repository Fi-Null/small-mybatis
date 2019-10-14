package com.small.mybatis.datasource;

import com.alibaba.druid.support.ibatis.DruidDataSourceFactory;

import javax.sql.DataSource;

/**
 * @ClassName DefaultDataSourceFactory
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 21:57
 * @Version 1.0
 **/
public class DefaultDataSourceFactory implements DataSourceFactory {
    public DataSource
    getDataSource(String name) {
        DataSource dataSource = null;
        if (name.equals("org.apache.commons.dbcp2.BasicDataSource")) {
            dataSource = new DBCPDataSourceFactory().getDataSource();
        } else
            dataSource = new DruidDataSourceFactory().getDataSource();
        return dataSource;
    }

    @Override
    public DataSource getDataSource() {
        return this.getDataSource("com.alibaba.druid.pool.DruidDataSource");
    }
}
