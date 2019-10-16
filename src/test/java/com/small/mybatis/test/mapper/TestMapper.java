package com.small.mybatis.test.mapper;

import com.small.mybatis.annotation.Pojo;
import com.small.mybatis.annotation.Select;
import com.small.mybatis.test.Test;

/**
 * @ClassName TestCustomMapper
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:40
 * @Version 1.0
 **/
@Pojo(Test.class)
public interface TestMapper {

    @Select("select * from test where id = %d")
    Test selectByPrimaryKey(int id);
}
