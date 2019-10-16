package com.small.mybatis.test;

import com.small.mybatis.session.SqlSession;
import com.small.mybatis.session.SqlSessionFactory;
import com.small.mybatis.test.mapper.TestMapper;

/**
 * @ClassName TestMybatis
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:30
 * @Version 1.0
 **/
public class TestMybatis {

    public static void main(String[] args) throws Exception {
        //        SqlSessionFactory factory = new SqlSessionFactory();
//        //没有插件且没有开启缓存
//        CustomSqlSession sqlSession1 = factory.build("com.test.mybatis.v2.mapper").openSqlSession();
//        TestCustomMapper mapper1 = sqlSession1.getMapper(TestCustomMapper.class);
//        Test test1 = mapper1.selectByPrimaryKey(1);
//        System.out.println("第一次查询结果为: " + test1);
//        test1 = mapper1.selectByPrimaryKey(1);
//        System.out.println("第二次查询结果为: " + test1);

//        SqlSessionFactory factory = new SqlSessionFactory();
//        //有插件但没有开启缓存
//        CustomSqlSession sqlSession2 = factory.build("com.test.mybatis.v2.mapper",
//                new String[] {"com.test.mybatis.v2.plugin.customPlugin.testPlugin"}).openSqlSession();
//        TestCustomMapper mapper2 = sqlSession2.getMapper(TestCustomMapper.class);
//        Test test2 = mapper2.selectByPrimaryKey(2);
//        System.out.println("第一次查询结果为: " + test2);
//        test2 = mapper2.selectByPrimaryKey(2);
//        System.out.println("第二次查询结果为: " + test2);

        SqlSessionFactory factory = new SqlSessionFactory();
        //有插件且有缓存
        SqlSession sqlSession3 = factory.build("com.small.mybatis.test.mapper",
                new String[]{"com.small.mybatis.test.plugin.TestPlugin"}, true).openSqlSession();
        TestMapper mapper3 = sqlSession3.getMapper(TestMapper.class);
        Test test3 = mapper3.selectByPrimaryKey(3);
        System.out.println("第一次查询结果为: " + test3);
        test3 = mapper3.selectByPrimaryKey(3);
        System.out.println("第二次查询结果为: " + test3);
    }
}
