package com.small.mybatis.session;

import com.small.mybatis.binding.MapperRegistry;

/**
 * @ClassName Configuration
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/13 23:57
 * @Version 1.0
 **/

public class Configuration {

    private MapperRegistry mapperRegistry;
    private String mapperInterfaceName;
    private String resultType;
    private String sql;
    private Class mapperInterface;
    private Class resultClass;
    private String dataSourceName;

    public Configuration() throws ClassNotFoundException {
        mapperInterfaceName = "batisDemo.dao.DepartmentMapper";
        sql = "select id,dept_name departmentName from t_dept where id = ${id}";
        resultType = "batisDemo.bean.Department";
        mapperInterface = Class.forName(mapperInterfaceName);
        resultClass = Class.forName(resultType);
        mapperRegistry = new MapperRegistry(this);
        dataSourceName = "org.apache.commons.dbcp2.BasicDataSource";
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return this.mapperRegistry.getMapper(type, sqlSession);
    }

//    public StatementHandler newStatementHandler(Object[] args) {
//        StatementHandler statementHandler = new RoutingStatementHandler(this, args);
//        return statementHandler;
//    }
//
//    public ParameterHandler newParameterHandler(Object[] args) {
//        ParameterHandler parameterHandler = new DefaultParameterHandler(this, args);
//        return parameterHandler;
//    }
//
//    public ResultSetHandler newResultHandler() {
//        ResultSetHandler resultSetHandler = new DefaultResultHandler(this);
//        return resultSetHandler;
//    }

    public MapperRegistry getMapperRegistry() {
        return mapperRegistry;
    }

    public void setMapperRegistry(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    public String getMapperInterfaceName() {
        return mapperInterfaceName;
    }

    public void setMapperInterfaceName(String mapperInterfaceName) {
        this.mapperInterfaceName = mapperInterfaceName;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Class getMapperInterface() {
        return mapperInterface;
    }

    public void setMapperInterface(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Class getResultClass() {
        return resultClass;
    }

    public void setResultClass(Class resultClass) {
        this.resultClass = resultClass;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }
}
