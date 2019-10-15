package com.small.mybatis;

import com.small.mybatis.session.SqlSession;
import com.small.mybatis.session.SqlSessionFactoryBuilder;

/**
 * @ClassName Test
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/15 23:43
 * @Version 1.0
 **/

public class Test {


    public void getMapper() throws Exception {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build().openSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.getDeptById(1);
        System.out.println(department);
    }


}
