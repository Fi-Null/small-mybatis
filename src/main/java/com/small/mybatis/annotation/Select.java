package com.small.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @ClassName Select
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:02
 * @Version 1.0
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {

    String value();
}
