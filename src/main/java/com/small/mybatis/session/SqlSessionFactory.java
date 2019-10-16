package com.small.mybatis.session;

/**
 * @ClassName SqlSessionFactory
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/16 23:38
 * @Version 1.0
 **/
public class SqlSessionFactory {

    private Configuration configuration;

    /**
     * 以下build方法将初始化Factory的属性Configuration，具体工作在Configuration构造器中完成
     */
    public SqlSessionFactory build(String mapperPath) throws Exception {
        return this.build(mapperPath, null, false);
    }

    public SqlSessionFactory build(String mapperPath, String[] pluginPath) throws Exception {
        return this.build(mapperPath, pluginPath, false);
    }

    public SqlSessionFactory build(String mapperPath, String[] pluginPath, boolean enableCache) throws Exception {
        configuration = new Configuration(mapperPath, pluginPath, enableCache);
        return this;
    }

    /**
     * 根据配置信息(Configuration)获取对应的SqlSession
     */
    public SqlSession openSqlSession() {
        return new SqlSession(configuration);
    }

}
