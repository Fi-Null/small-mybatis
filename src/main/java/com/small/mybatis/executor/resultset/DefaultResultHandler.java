package com.small.mybatis.executor.resultset;

import com.small.mybatis.session.Configuration;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DefaultResultHandler
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 22:30
 * @Version 1.0
 **/
public class DefaultResultHandler implements ResultSetHandler {

    private Configuration configuration;

    public DefaultResultHandler(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> handleResultSets(Statement statement) throws Exception {
        List<E> list = new ArrayList<E>();
        ResultSet rs = null;
        if (statement instanceof PreparedStatement) {
            PreparedStatement ps = (PreparedStatement) statement;
            rs = ps.executeQuery();
            System.out.println("preparedStatement");
        } else {
            String sql = this.configuration.getSql();
            rs = statement.executeQuery(sql);
            System.out.println("statement");
        }
        ResultSetMetaData rsmd = rs.getMetaData();
        Class resultClazz = configuration.getResultClass();
        Object resBean = resultClazz.newInstance();
        Field[] fields = resultClazz.getDeclaredFields();
        Map<String, Object> map = new HashMap<>();
        while (rs.next()) {
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                String name = rsmd.getColumnLabel(i + 1);
                for (Field field : fields) {
                    if (field.getName().equals(name)) {
                        Object object = rs.getObject(i + 1);
                        map.put(name, object);
                        break;
                    }
                }
            }
            try {
                BeanUtils.populate(resBean, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            list.add((E) resBean);
        }
        return list;
    }

}
