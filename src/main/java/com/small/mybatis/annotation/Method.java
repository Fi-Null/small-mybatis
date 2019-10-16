package com.small.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @ClassName Method
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:00
 * @Version 1.0
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Method {

    String value();
}
