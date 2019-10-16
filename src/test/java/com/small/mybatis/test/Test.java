package com.small.mybatis.test;

/**
 * @ClassName Test
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/15 23:43
 * @Version 1.0
 **/

public class Test {

    private Integer id;
    private Integer nums;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", nums=" + nums +
                ", name='" + name + '\'' +
                '}';
    }

}
