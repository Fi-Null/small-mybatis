package com.small.mybatis;

/**
 * @ClassName DepartmentMapper
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/15 23:44
 * @Version 1.0
 **/
public interface DepartmentMapper {

    public Department getDeptById(Integer id);

    public Department getDeptByIdStep(Integer id);

}
