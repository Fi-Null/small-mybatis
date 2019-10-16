package com.small.mybatis.executor;

/**
 * @ClassName SimpleExecutor
 * @Description TODO
 * @Author xiangke
 * @Date 2019/10/14 23:29
 * @Version 1.0
 **/
public class SimpleExecutor implements Executor {
    /**
     * 这里为默认Executor，细化了责任，查询交给StatementHandler处理
     */
    @Override
    public <T> T query(String statement, String parameter, Class pojo) throws Exception {
        StatementHandler statementHandler = new StatementHandler();
        return statementHandler.query(statement, parameter, pojo);
    }
}
