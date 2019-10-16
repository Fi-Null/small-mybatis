package com.small.mybatis.plugin;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName InterceptorChain
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:25
 * @Version 1.0
 **/
public class InterceptorChain {
    private final List<Interceptor> interceptors = new ArrayList<>();

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    /**
     * 将目标executor依此按照插件链动态代理target
     * 如有多个plugin，多次代理(如b插件代理了a执行器，c插件又代理a执行器，此时执行顺序为c -> b -> a)
     */
    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }

    public boolean hasPlugin() {
        if (interceptors.size() == 0) {
            return false;
        }
        return true;
    }
}
