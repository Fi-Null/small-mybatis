package com.small.mybatis.session;

import java.util.List;

/**
 * @ClassName MapperBean
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 21:44
 * @Version 1.0
 **/
public class MapperBean {

    private String interfaceName; //接口名
    private List<Function> functions; //接口下所有方法
    private Class mapperInterface;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    public Class getMapperInterface() {
        return mapperInterface;
    }

    public void setMapperInterface(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }
}
