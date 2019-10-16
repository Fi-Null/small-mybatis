package com.small.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @ClassName Pojo
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:01
 * @Version 1.0
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Pojo {
    Class<?> value();
}
