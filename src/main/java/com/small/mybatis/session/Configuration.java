package com.small.mybatis.session;

import com.small.mybatis.binding.MapperRegistry;
import com.small.mybatis.executor.parameter.DefaultParameterHandler;
import com.small.mybatis.executor.parameter.ParameterHandler;
import com.small.mybatis.executor.resultset.DefaultResultHandler;
import com.small.mybatis.executor.resultset.ResultSetHandler;
import com.small.mybatis.executor.statement.RoutingStatementHandler;
import com.small.mybatis.executor.statement.StatementHandler;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName Configuration
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/13 23:57
 * @Version 1.0
 **/

public class Configuration {

    private MapperBean mapperBean;

    private static ClassLoader loader = ClassLoader.getSystemClassLoader();

    private MapperRegistry mapperRegistry;
//    private String mapperInterfaceName;
//    private String resultType;
//    private String sql;
//    private Class mapperInterface;
//    private Class resultClass;
    private String dataSourceName;

    public Configuration(String path) throws ClassNotFoundException {

        mapperBean = readMapper(path);

//        mapperInterfaceName = "batisDemo.dao.DepartmentMapper";
//        sql = "select id,dept_name departmentName from t_dept where id = ${id}";
//        resultType = "batisDemo.bean.Department";
//        mapperInterface = Class.forName(mapperInterfaceName);
//        resultClass = Class.forName(resultType);
         mapperRegistry = new MapperRegistry(this);
         dataSourceName = "org.apache.commons.dbcp2.BasicDataSource";
    }

    private MapperBean readMapper(String path) throws ClassNotFoundException {
        MapperBean mapper = new MapperBean();
        try {
            InputStream stream = loader.getResourceAsStream(path);
            SAXReader reader = new SAXReader();
            Document document = reader.read(stream);
            Element root = document.getRootElement();
            String nameSpace = root.attributeValue("nameSpace").trim();
            mapper.setInterfaceName(nameSpace); //把mapper节点的nameSpace值存为接口名
            mapper.setMapperInterface(Class.forName(nameSpace));
            List list = new ArrayList();
            for (Iterator rootIter = root.elementIterator(); rootIter.hasNext(); ) {//遍历根节点下所有子节点
                Function fun = new Function();    //用来存储一条方法的信息
                Element e = (Element) rootIter.next();
                //String sqltype = e.getName().trim();
                String funcName = e.attributeValue("id").trim();
                String sql = e.getText().trim();
                String resultType = e.attributeValue("resultType").trim();
                //fun.setSqltype(sqltype);
                fun.setFuncName(funcName);
                Object newInstance = null;
                try {
                    newInstance = Class.forName(resultType).newInstance();
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                fun.setResultType(newInstance);
                fun.setSql(sql);
                list.add(fun);
            }
            mapper.setFunctions(list);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return mapper;
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return this.mapperRegistry.getMapper(type, sqlSession);
    }

    public StatementHandler newStatementHandler(Object[] args) {
        StatementHandler statementHandler = new RoutingStatementHandler(this, args);
        return statementHandler;
    }

    public ParameterHandler newParameterHandler(Object[] args) {
        ParameterHandler parameterHandler = new DefaultParameterHandler(this, args);
        return parameterHandler;
    }

    public ResultSetHandler newResultHandler() {
        ResultSetHandler resultSetHandler = new DefaultResultHandler(this);
        return resultSetHandler;
    }

    public MapperRegistry getMapperRegistry() {
        return mapperRegistry;
    }

    public void setMapperRegistry(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

//    public String getMapperInterfaceName() {
//        return mapperInterfaceName;
//    }
//
//    public void setMapperInterfaceName(String mapperInterfaceName) {
//        this.mapperInterfaceName = mapperInterfaceName;
//    }
//
//    public String getResultType() {
//        return resultType;
//    }
//
//    public void setResultType(String resultType) {
//        this.resultType = resultType;
//    }
//
//    public String getSql() {
//        return sql;
//    }
//
//    public void setSql(String sql) {
//        this.sql = sql;
//    }
//
//    public Class getMapperInterface() {
//        return mapperInterface;
//    }
//
//    public void setMapperInterface(Class mapperInterface) {
//        this.mapperInterface = mapperInterface;
//    }
//
//    public Class getResultClass() {
//        return resultClass;
//    }
//
//    public void setResultClass(Class resultClass) {
//        this.resultClass = resultClass;
//    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public MapperBean getMapperBean() {
        return mapperBean;
    }

    public void setMapperBean(MapperBean mapperBean) {
        this.mapperBean = mapperBean;
    }
}
